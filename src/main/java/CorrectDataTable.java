import java.util.TreeMap;

public class CorrectDataTable {

    private TreeMap<String, String> dataTableTreeMap() {
        TreeMap<String, String> correctDataTable = new TreeMap<>();

        correctDataTable.put("data11", "Smith");
        correctDataTable.put("data12", "Bach");
        correctDataTable.put("data13", "Doe");
        correctDataTable.put("data14", "Conway");

        correctDataTable.put("data21", "John");
        correctDataTable.put("data22", "Frank");
        correctDataTable.put("data23", "Jason");
        correctDataTable.put("data24", "Tim");

        correctDataTable.put("data31", "jsmith@gmail.com");
        correctDataTable.put("data32", "fbach@yahoo.com");
        correctDataTable.put("data33", "jdoe@hotmail.com");
        correctDataTable.put("data34", "tconway@earthlink.net");

        correctDataTable.put("data41", "$50.00");
        correctDataTable.put("data42", "$51.00");
        correctDataTable.put("data43", "$100.00");
        correctDataTable.put("data44", "$50.00");

        correctDataTable.put("data51", "http://www.jsmith.com");
        correctDataTable.put("data52", "http://www.frank.com");
        correctDataTable.put("data53", "http://www.jdoe.com");
        correctDataTable.put("data54", "http://www.timconway.com");

        return correctDataTable;
    }

    public TreeMap<String, String> getCorrectDataTable() {
        return dataTableTreeMap();
    }
}

