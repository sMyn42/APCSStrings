package base.bookexercises;

public class BookStrings {

    public static String scroll(String s){
        return s.substring(1) + s.charAt(0);
    }

    public static String convertName(String name){
        String converted = "";
        int commaIndex = name.indexOf(",");
        String first = name.substring(commaIndex + 1).trim();
        String last = name.substring(0, commaIndex).trim();
        converted = first + " " + last;
        return converted;
    }

    public static String changeBinary(String inputString){
        return inputString.replaceAll("1", "A").replaceAll("0", "1").replaceAll("A", "0");
    }

    public static String convertDate(String dateString){
        String month = dateString.substring(0, dateString.indexOf("/"));
        String day = dateString.substring(dateString.indexOf("/") + 1, dateString.lastIndexOf("/"));
        String year = dateString.substring(dateString.lastIndexOf("/") + 1);
        return day+"-"+month+"-"+year;
    }

    public static String convertDate2(String dateString){
        String month = dateString.substring(0, dateString.indexOf("/"));
        String day = dateString.substring(dateString.indexOf("/") + 1, dateString.lastIndexOf("/"));
        String year = dateString.substring(dateString.lastIndexOf("/") + 1);

        //extras
        if (day.length() < 2) day = "0" + day;
        if (month.length() < 2) month = "0" + month;
        //end

        return day+"-"+month+"-"+year;
    }

    public static boolean startsWith(String s, String prefix){
        if(prefix.length() > s.length()) return false;
        return s.substring(0, prefix.length()).equals(prefix);
    }

    public static boolean endsWith(String s, String suffix){
        if(suffix.length() > s.length()) return false;
        return s.substring(s.length() - suffix.length()).equals(suffix);
    }

    public static String removeTag(String tagged, String tag){
        if (tagged.indexOf("<") == -1 || tagged.indexOf("<") == -1 || tagged.indexOf("/") == -1) return tagged;
        int tagOneStart = tagged.indexOf("<");
        int tagTwoStart = tagged.lastIndexOf("</");
        int tagOneEnd = tagged.indexOf(">");
        int tagTwoEnd = tagged.lastIndexOf(">");
        if (tagTwoEnd == tagTwoStart + 3 && tagOneEnd == tagOneStart + 2){
            if (tagged.substring(tagTwoStart + 2, tagTwoStart + 3).equals(tag) && tagged.substring(tagOneStart + 1, tagOneStart + 2).equals(tag)){
                return tagged.substring(tagOneEnd + 1, tagTwoStart);
            }
        }
        return tagged;
    }

    public static void main(String[] args){
        System.out.println("by: " + convertName("   Mynampati ,  Saketh "));

        System.out.println("\nScroll");
        System.out.println(scroll("Hello World"));

        System.out.println("\nNegative");
        System.out.println(changeBinary("0010111001"));

        System.out.println("\nConvert Date to European Format");
        System.out.println("11/06/2020 becomes " + convertDate("11/06/2020"));

        System.out.println("\nConvert Date to European Format - Flexible");
        System.out.println("04/20/2014 becomes " + convertDate2("04/20/2014"));
        System.out.println("4/20/2014 becomes " + convertDate2("4/20/2014"));
        System.out.println("04/2/2014 becomes " + convertDate2("04/2/2014"));
        System.out.println("4/2/2014 becomes " + convertDate2("4/2/2014"));

        System.out.println("\nstartsWith");
        System.out.print(startsWith("architecture", "arch"));
        System.out.println("      Expected: " + "architecture".startsWith("arch"));
        System.out.print(startsWith("architecture", "a"));
        System.out.println("      Expected: " + "architecture".startsWith("a"));
        System.out.print(startsWith("arch", "architecture"));
        System.out.println("      Expected: " + "arch".startsWith("architecture"));
        System.out.print(startsWith("architecture", "rch"));
        System.out.println("      Expected: " + "architecture".startsWith("rch"));
        System.out.print(startsWith("architecture", "architecture"));
        System.out.println("      Expected: " + "architecture".startsWith("architecture"));

        System.out.println("\nendsWith");
        System.out.print(endsWith("astronomy", "nomy"));
        System.out.println("      Expected: " + "astronomy".endsWith("nomy"));
        System.out.print(endsWith("astronomy", "y"));
        System.out.println("      Expected: " + "astronomy".endsWith("y"));
        System.out.print(endsWith("astronomy", "nom"));
        System.out.println("      Expected: " + "astronomy".endsWith("nom"));
        System.out.print(endsWith("nomy", "astronomy"));
        System.out.println("      Expected: " + "nomy".endsWith("astronomy"));
        System.out.print(endsWith("astronomy", "astronomy"));
        System.out.println("      Expected: " + "astronomy".endsWith("astronomy"));

        System.out.println("\nRemove HTML-style tags");
        System.out.println(removeTag("<b>Hello World</b>", "b"));
        System.out.println(removeTag("Hello World</b>", "b"));
        System.out.println(removeTag("<b>Hello World", "b"));
        System.out.println(removeTag("</b>Hello World<b>", "b"));
        System.out.println(removeTag("Happy Birthday <b>Hello World</b>", "b"));
        System.out.println(removeTag("<b>Hello World</b> Happy Birthday", "b"));
        System.out.println(removeTag("Happy <b>Hello World</b> Birthday", "b"));

    }

}
