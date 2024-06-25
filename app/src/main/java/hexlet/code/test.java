//package hexlet.code;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class test {
//    public static void main(String[] args) {
////        try {
////            // create object mapper instance
////            ObjectMapper mapper = new ObjectMapper();
////
////            // convert JSON file to map
////            Map<?, ?> map = mapper.readValue(Paths.get("/home/paradox/JavaProject/java-project-71/app/src/main/resources/file1.json").toFile(), Map.class);
////
////            // print map entries
////            for (Map.Entry<?, ?> entry : map.entrySet()) {
////                System.out.println(entry.getKey() + "=" + entry.getValue());
////            }
////
////        } catch (Exception ex) {
////            ex.printStackTrace();
////        }
////
////        Map<?, ?> unsortedMap = Map.of("a", 1, "c", 3, "b", 2, "e", 5, "d", 4);
////
////        Map<?, ?> sortedTreeMap = new TreeMap<>(unsortedMap);
////
////        System.out.println(sortedTreeMap);
//        Path resourceDirectory = Paths.get("src","test","resources");
//        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
//
//        System.out.println(absolutePath);
//
//
//    }
//}
