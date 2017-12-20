package algorithm.java;

import org.junit.Test;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;

/************************************************************************************
 * 功能描述：
 *
 * 给定一个目录，遍历该目录及该目录下的所有文件
 *
 * 要考虑的地方：
 * ①递归的话，可能由于目录过深，而导致栈溢出
 * ②非递归的话，要及时从集合中删掉已去读的文件
 * ③Java新的API的使用
 *
 * 其他：
 * list()返回的是相对路径
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年12月20日 --  下午10:11 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class FileTraversal {

    /**
     * 递归实现
     *
     *
     *
     * @param filePath
     */
    public void fileTraversalRect(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        } else {
            if (file.isFile()) {
                readFile(file);
            } else if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null && files.length > 0) {
                    for (File childFile : files) {
                        fileTraversalRect(childFile.getAbsolutePath());
                    }
                }
            }
        }
    }


    /**
     * 读取文件
     *
     * 要注意，防止读取大文件时内存溢出
     *
     * @param file
     */
    public void readFile(File file) {
        System.out.println("【" + file.getName() + "】:" + file.getAbsolutePath());

        //逐行读取，防止文件过大导致内存溢出
        // 10M缓存
        int bufferSize = 10*1024*1024;
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedReader in = new BufferedReader(new InputStreamReader(bis, "utf-8"), bufferSize);
            while (in.ready()) {
                String line = in.readLine();
                System.out.println(line);
            }
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 非递归实现
     *
     * 使用一个链表存储文件夹
     *
     *
     * @param filePath
     */
    public void fileTraversal(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        } else {
            if (file.isFile()) {
                readFile(file);
            } else if (file.isDirectory()) {
                //该fileList只保存文件夹，且在读取某文件夹后，就删除该文件夹
                LinkedList<File> fileList = new LinkedList<>();
                fileList.add(file);
                while (!fileList.isEmpty()) {
                    File first = fileList.removeFirst();
                    File[] childFiles = first.listFiles();
                    for(File childFile : childFiles){
                        if (childFile.isFile()) {
                            readFile(childFile);
                        } else if (childFile.isDirectory()) {
                            fileList.add(childFile);
                        }
                    }
                }
            }
        }
    }

    /**
     * 使用JDK1.7新增的API实现
     *
     * @param filepath
     */
    public void fileTraversal2(String filepath){
        Path path = Paths.get(filepath);
        SimpleFileVisitor<Path> finder = new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                readFile(file.toFile());
                return super.visitFile(file, attrs);
            }
        };

        try {
            Files.walkFileTree(path, finder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test() {
        File[] files = File.listRoots();
        String path = "/Users/yue/Documents/workspace/idea/simpleAlgorithm";

        //fileTraversalRect(files[0].getAbsolutePath());
        fileTraversal2(path);
    }


}
