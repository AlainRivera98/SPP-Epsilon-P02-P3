//Proyecto Parcial 2
//Problema 3
//Equipo Epsilon
//Nombres, matrículas y carreras de integrantes de equipo:
//Roberto Alain Rivera Bravo | A01411516 | IMT11
//Fabricio Arturo Balboa Cavazos | A01411541 | IMT11
//Andrés de Jesús Martínez Castillo | A01411447 | IMT11
//Jessica Delgado González | A01411536 | IMT11
//Alfredo Alejandro Lárraga Sosa | A01410278 | LMC

/*
3.Desarrolle un programa en java que recorra un arreglo de enteros con dimensión y 
contenido determinado por el usuario, que imprima tantos caracteres * como el valor de 
cada elemento del arreglo separados por un guion. 
Ejemplo: 
Arreglo = {{1,3},{2,5}}  
Pantalla= * - ***
	  ** - *****
*/

package spp.epsilon.p02.p3;
import java.util.Scanner;

public class SPPEpsilonP02P3 {

    public static void main(String[] args) {
        boolean flag;
        
        do{        
            menu(); //manda a método menú
            flag = salida(); //recibe el valor booleano
        } while (flag==false);
    }
    
    //método menú: muestra las opciones en pantalla
    public static void menu(){     
        Scanner teclado = new Scanner (System.in);
        String message;
        
        System.out.println("-----------------------");        
        System.out.println("Matriz de números a asteriscos");
        System.out.println("-----------------------"); 
        
        System.out.println("¿Desea empezar el programa?");
        System.out.println("SI. Presione 1");
        System.out.println("NO. Presione cualquier otra tecla");
        message = teclado.next();
        
        if(message.equals("1")){
            crearMatrices();
        }

    }
    
    /*método crear matrices: relaciona a los métodos para crear matrices, asignarles datos
    y transformar en asteriscos los valores de las matrices*/
    public static void crearMatrices(){
        int m, n;

        //Se asigna la dimensión de la matriz
        m = verificarIntPositivo("i","A");
        n = verificarIntPositivo("j","A");

        //Se asignan valores a la matriz A
        System.out.println("\nValores de matriz A");
        int[][]A = asignarValores(m,n);
     
        System.out.println("\nLa transformada en asteriscos de la matriz A");
        mostrarArray(A);
        System.out.println("\nes: ");
        transformarMatriz(A,m,n);

    }
       
    //Método solicitar datos: permite verificar que los datos sean correctos y los captura
    public static int solicitarDatos(){
        Scanner teclado = new Scanner (System.in);
        int x=0;
        boolean flag;

        do {
            try { //Intenta realizar las instrucciones
                x = teclado.nextInt();
                flag = true;
            } catch (Exception ex) { //Evita que el programa falle en caso de error y muestra el error
                System.out.println("\nIntroduzca un número entero válido");
                System.out.println(ex);
                flag = false;
                teclado.next(); //Limpia el buffer del teclado
            }
     
        } while (flag == false);
        
        return x; //regresa el valor verificado
    }
    
    /*Método verificar int positivo: verifica que el entero sea positivo para evitar introducir
    valores negativos en el tamaño de la matriz*/
    public static int verificarIntPositivo(String a, String b){
        boolean flag;
        int x;
        
        System.out.println("\nIntroduzca la dimensión "+a+" de la matriz "+b);
        //Ciclo do while: ejecuta al menos una vez las instrucciones en do, y evalúa si es cierto en while
        do {
            x = solicitarDatos();
            //Evalúa si la x es menor a uno, y si lo es, asigna flag=false para repetir el ciclo
            if (x < 1) {
                System.out.println("Introduzca un entero positivo(no hay longitudes negativas  o nulas de matrices)");
                flag=false;
            } else{
              flag=true;  
            }
            
        } while (flag==false);
    
        return x; //regresa el valor comprobado
    }        
    
    //Método asignar valores: asigna los valores de una matriz con un ciclo for
    public static int[][] asignarValores(int m, int n){
        int[][] matrix = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Introduzca el valor de la posición "+i+","+j);
                matrix[i][j] = solicitarDatos();
            }
        }
 
        return matrix; //regresa la matriz a la que se le asignaron valores
    }
    
    //método transformar matriz: transforma la matriz de números a asteriscos según las reglas establecidas
    public static void transformarMatriz(int[][]A, int m, int n){
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < A[i][j]; k++) {
                    System.out.print("*");
                }
                if(j!=(n-1)){
                    System.out.print(" - ");
                }
            }
            System.out.println("\t");
        }
    }
    
    //Método mostrar Array: muestra en pantalla la matriz creada
    public static void mostrarArray(int [][]matrix){ //Se recibe el objeto matrix
        //Recorre las "i" filass del array
        for(int i=0; i<matrix.length; i++){
            //Recorre las "j" columnas del array
            for (int j=0; j<matrix[i].length; j++){
                System.out.print("["+matrix[i][j]+"]");
            }
            /*Introduce un salto de línea cada que se rebase la cantidad de columnas del array
            para que se vea el arreglo en orden en pantalla*/
            System.out.println("\t");
        } 
        
    }
    
    //Método salir: da opción de terminar o reiniciar los cálculos   
    public static boolean salida(){
        Scanner teclado = new Scanner (System.in);
        String option;
        boolean flag;
        
        System.out.println("\n¿Desea salir?");
        System.out.println("SI: Presione 1");
        System.out.println("NO: Presione cualquier otra tecla");
        option = teclado.next();
        
        //verifica si el String es igual a "1"
        if(!option.equals("1")){
             //Se manda el valor booleano para volver a ejecutar el programa
            flag=false;
            System.out.println("\n\n");
        } else{
            //Se manda el valor booleano para terminar el programa
           flag=true; 
        }
        
        return flag;  //Se regresa el valor booleano
    }
    
}
