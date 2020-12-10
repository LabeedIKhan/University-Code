import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader


fun <T> MyListIterator(list : ArrayList<T>){

    val it = list.iterator()
    System.out.println("Title - Original ArrayList"+"\n");
    while(it.hasNext()){
        println(it.next())
    }
}

fun <T> MyEnhancedLoop(list: ArrayList<String>) {

    list.add(0 , "Peterhead Prison Museum")
    list.add(1, "Wick Heritage Museum")

    System.out.println("\n"+"Title - ArrayList after adding elements"+"\n");
    for ( item in list) {
        println(item)
    }
}


fun MyWhileLoop(list: ArrayList<String>){

    var i = 0

    System.out.println("\n"+"Title - ArrayList after remove operation"+"\n");

    while(i < list.size){

        if (list.get(i) == "Camera Obscura and World of Illusions"){
            list.removeAt(i)
        }
        println(list.get(i))
        i++
    }
}

fun MyForLoop(list : ArrayList<String>){

    System.out.println("\n"+"Title - Final ArrayList"+"\n");

    for ( i in 0 until list.size-1){

        if ((i == 4) and !list.get(i).equals(null)){
            list.removeAt(i)
            continue
        }
        println(list.get(i))
    }
}

fun ReadFile() : List<String>{

    val file = File("profile.txt")
    val buffreader = file.bufferedReader()
    var text: List<String> = buffreader.readLines()

    for (line in text){
        println(line)
    }
    return text
}



fun main(args: Array<String>) {

    val list: ArrayList<String> = ArrayList()
    list.add("Kelvingrove Art Gallery and Museum");
    list.add("National Museum of Scotland");
    list.add("Royal Yacht Britannia");
    list.add("Camera Obscura and World of Illusions");
    list.add("Morayvia");
    list.add("Montrose Air Station Heritage Centre");

    MyListIterator(list)
    MyEnhancedLoop<String>(list)
    MyWhileLoop(list)
    MyForLoop(list)

    val filelist = ReadFile()

    println("\n\n\n")
    for (line in filelist){
        println(line)
    }
}