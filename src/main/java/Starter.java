import com.fasterxml.jackson.databind.ObjectMapper;
import model.Book;
import model.TestDate;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Starter {

    public static void main(String[] args) throws IOException, ParseException {
        Book book1 = new Book();
        book1.setId("1");
        book1.setName("Book1");
        book1.setAuthor("Kate");
        book1.setPublisher("Amazon");
        book1.setPublicationDate("2022");

        StringWriter writer = new StringWriter();

        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(writer, book1);
        String result = writer.toString();
        System.out.println(result);

        String jsonString = "{\"id\":\"2\",\"name\":\"Book2\",\"author\":\"Mary\",\"publisher\":\"LG\", \"year\":\"2020\"}";
        Book book2 = new ObjectMapper().readValue(jsonString, Book.class);
        System.out.println(book2);


        List<Book> library = new ArrayList<>();
        library.add(book1);
        library.add(book2);
        String jsonlist = mapper.writeValueAsString(library);
        System.out.println(jsonlist);


        JSONObject obj=new JSONObject();

        obj.put("id",1);
        obj.put("name", "Book1") ;
        obj.put("author", "Kate") ;
        obj.put("publisher","Amazon");
        obj.put("publicationDate", "2022");
        System.out.println("id:"+obj.get("id"));
        System.out.println("Name:"+obj.get("name"));
        System.out.println("Author:" + obj.get("author"));
        System.out.println("Publisher:" + obj.get("publisher"));
        System.out.println("PublicationDate: " + obj.get("publicationDate"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String toParse = "16-03-2001";
        Date date = dateFormat.parse(toParse);
        TestDate event = new TestDate("bithday", date);

        String result1 = new ObjectMapper().writeValueAsString(event);
        System.out.println(result1);

        String json1 = "{\"event\":\"party\",\"date\":\"11.02.2022\"}";

        TestDate event1 = new ObjectMapper().readerFor(TestDate.class).readValue(json1);
        System.out.println(event1);

    }

}
