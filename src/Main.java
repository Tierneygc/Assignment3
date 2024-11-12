//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        RedBlackBST<String, Product> products = new RedBlackBST<String, Product>();

        String csvFile = "src/amazon-product-data.csv";
        String line = "";
        String csvSplitBy = ",";
        int k = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
br.readLine();
            while (k < 100 && (line = br.readLine()) != null) {

                // Use comma as separator
                String[] data = line.split(csvSplitBy);

                for(String d : data){
                    System.out.println(d);

                }
                System.out.println();

                // Process the data
                String productId = data[0];
                String productName = data[1];
                String productCategory = data[2];
                String productPrice = data[3];

                Product product = new Product(productName, productCategory,  productPrice);
                products.put(productId, product);


                k++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(products.isBalanced());


        }
    }
