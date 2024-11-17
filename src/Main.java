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

        int k = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            line = br.readLine();
            System.out.println("lll" + line);
            while ((line = br.readLine()) != null) {


                System.out.println("l" + line);
                Product product = parseProduct(line);

                products.put(product.getProductId(), product);

//k++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(products.isBalanced());


        }

       public static Product parseProduct(String line){
           String productId = "";
           String productName = "";
           String productCategory = "";
           String productPrice = "";

           boolean inQuote = false;
           int a = 1;

           char curr = line.charAt(0);
           StringBuilder sb = new StringBuilder("");

           for (int i = 0; i < line.length(); i++){
               curr = line.charAt(i);
               if (curr == '\"'){
                   inQuote = !inQuote;
               }
               else if(inQuote == false && curr == ','){

                   if (a == 1){

                       productId = sb.toString();
                       sb.setLength(0);

                   }
                   else if (a == 2){

                       productName = sb.toString();
                       sb.setLength(0);


                   }
                   else if (a == 3){

                       productCategory = sb.toString();
                       sb.setLength(0);


                   }

                   a++;
               }
               else{
                   sb.append(curr);
               }

           }
           if (a == 4){
               productPrice = sb.toString();

               sb.setLength(0);
           }


           Product product = new Product(productId, productName, productCategory, productPrice);
//           System.out.println(product.productId);
//           System.out.println(product.productName);
//           System.out.println(product.productCategory);
//           System.out.println(product.productPrice);
           return product;



        }
    }
