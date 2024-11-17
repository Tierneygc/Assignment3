//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RedBlackBST<String, Product> products = new RedBlackBST<String, Product>();

        String csvFile = "src/amazon-product-data.csv";
        String line = "";

        int k = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            line = br.readLine();
            System.out.println("lll" + line);
            while (k < 10001 &&(line = br.readLine()) != null) {


                System.out.println("l" + line);
                Product product = parseProduct(line);

                products.put(product.getProductId(), product);

k++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }



        //System.out.println(products.isBalanced());
        Product product = new Product ("2bb94aefc3467ed83860e0e2712d5f10","Hasegawa Ladders Lucano Step Ladder, Orange","Home & Kitchen | Furniture | Kids' Furniture | Step Stools","$152.27");
        products.put(product.productId, product);
        products.put(product.productId, product);

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            System.out.println("search product id:");
            String searchFor = scanner.nextLine();

            if (products.contains(searchFor)) {
                Product product1 = products.get(searchFor);
                System.out.println(product1.productName);
                System.out.println(product1.productCategory);
                System.out.println(product1.productPrice);
            } else {
                System.out.println("Product does not exist");

            }
        }




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
