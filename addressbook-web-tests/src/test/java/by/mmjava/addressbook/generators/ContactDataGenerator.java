package by.mmjava.addressbook.generators;

import by.mmjava.addressbook.model.ContactData;
import by.mmjava.addressbook.model.GroupData;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 5/26/2017.
 */
public class ContactDataGenerator {

    @Parameter(names = "-c", description="Contact count")
    public int count;

    @Parameter (names = "-f", description="Target File")
    public String file;

    @Parameter (names = "-d", description="Data format")
    public String format;

    public static void main (String[] args) throws IOException {
        ContactDataGenerator  generator = new ContactDataGenerator();
        JCommander jCommander =new JCommander(generator);
        try {
            jCommander.parse(args);
        }catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts= generateContacts(count);
        if (format.equals("csv")){
            saveAsCSV(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXML(contacts, new File(file));
        }
        else if (format.equals("json")) {
            saveAsJSON(contacts, new File(file));
        }
        else {
            System.out.println("unrecognized format" + format);
        }
    }

    private void saveAsJSON(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();    //форматирование результата )beatify)
        String json = gson.toJson(contacts);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();

    }

    private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        String xml = xstream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private  void saveAsCSV(List<ContactData> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts){
            writer.write(String.format("%s;%s;%s;%s\n",contact.getFirstname(),contact.getMiddlename(),contact.getLastname(),contact.getGroup()));
        }
        writer.close();
    }

    private  List<ContactData> generateContacts(int count) {
        List <ContactData> contacts = new ArrayList<ContactData>();
        for (int i=0;i< count;i++) {
            contacts.add(new ContactData().withFirstname(String.format("First name %s", i))
                    .withMiddlename(String.format("Middle name %s", i)).withLastname(String.format("Last name %s", i)).withGroup(String.format("new")));
        }

        return contacts;
    }
}
