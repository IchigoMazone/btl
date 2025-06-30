package org.example.utils;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class FileUtils {
    public static void writeXMLtoFile(String fileName, Object object) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Hàm generic trả về đúng kiểu T thay vì Object
     */
    public static <T> T readXMLFile(String fileName, Class<T> clazz) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return clazz.cast(unmarshaller.unmarshal(new File(fileName)));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}


