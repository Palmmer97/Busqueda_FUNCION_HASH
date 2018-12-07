/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcion_hash;

import java.util.Arrays;

/**
 *
 * @author ALEJANDRO LOPEZ GARCIA 16210545
 * FUNCION HASH 
Es una funcion de busqueda el cual no requiere que los elementos se encuentren ordenados, esta consiste en asginar a cada elemento un indice
* el cual mediante 
una transformacion del elemento. un ejemplo es que a cierto numero se le asigna cierto indice y asi sucesivamente, tomando en cuenta 
* que solo es a numeraciones
pequeñas debido a que la funcion se vuelve inservible, esta tambien utiliza tablas la cual los elmentos estan formados por una pareja claro,
* clave y valor, es muy 
parecido a un SortedList, pero la diferencia de este esta enla forma en que se manejan internamente ciertos datos: esta tabla usa una funcion
* de dispercion para 
colocar los elementos, de forma que no se pueden recorrer secuencialmente, pero con el acceso a la clave es mas rapido
 */

public class FUNCION_HASH {

    /**
     * @param args the command line arguments
     */// ARREGLO
    String [] arreglo;
    int tamaño, contador;
    // CONSTRUCTOR 
    public FUNCION_HASH (int tam)
    {
    tamaño = tam;
    arreglo = new String [tam];
    Arrays.fill(arreglo,"-1");
    }
    public void funcionHASH(String[] cadenaArreglo,String[] arreglo) 
    {
        int i;
        for (i=0; i<cadenaArreglo.length;i++) 
        {
            String elemento=cadenaArreglo[i];
            int indiceArreglo=Integer.parseInt(elemento)%7;
            System.out.println("El indice es"+indiceArreglo+"Para el Elemento"+
                    elemento);
           // Se Tratan las coliciones
            while (arreglo[indiceArreglo]!="-1")
            {
                indiceArreglo++;
                System.out.println("Ocurrio una colision en el indice"+
                        (indiceArreglo-1)+
                        "Cambiar al Indice"+ indiceArreglo);
                indiceArreglo%=tamaño;
            }
            arreglo[indiceArreglo]=elemento;
        }
    }
    
    // Metodo donde se muestra la tabla
    public void mostrar()
    {
        int incremento = 0,i,j;
        for(i=0;i<1;i++)
        {
            incremento +=8;
            for(j=0;j<70;j++)
            {
                System.out.println("-"); 
            }
            System.out.println();
            for(j=incremento-8;j<incremento;j++)
            {
                System.out.format("|%3s"+"",j);
            }
            System.out.println("|");
            for(int n=0;n<70;n++)
            {
                System.out.println("-");
            }
            System.out.println();
            for(j=incremento-8;j<incremento;j++)
            {
                if (arreglo[j].equals("-1"))
                {
                    System.out.println("|");
                }
                else
                {
                    System.out.println(String.format("|%3s"+"", arreglo[j]));
                }
            }
            System.out.println("|");
            for (j=0;j<71;j++)
            {
                System.out.println("-");
            }
            System.out.println();  
        }
    }
    // Metodo para buscar clave
     
    public String buscarClave(String elemento)
    {
        int indiceArreglo=Integer.parseInt(elemento)%7;
        int contador=0;
        while (arreglo[indiceArreglo]!="-1")
        {
           if(arreglo[indiceArreglo]==elemento)
           {
           System.out.println("El elemento"+elemento+"Fue encontrado en el indice"+ indiceArreglo);
             return arreglo[indiceArreglo];
           }
           indiceArreglo++;
           indiceArreglo%=tamaño;
           contador++;
           if ( contador>7)
           {
               break;
           }
        }
        return null;
        
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        FUNCION_HASH OBJ=new FUNCION_HASH(8);
        String [] elementos={"20","500","84","41","60","90","75","23"};
        // le enviamos los elementos al arreglo 
        OBJ.funcionHASH(elementos, OBJ.arreglo);
        OBJ.mostrar();
        String buscando=OBJ.buscarClave("500");
        if (buscando == null)
        {
            System.out.println("El elemento "+buscando+" No se encuentra en la tabla");
        }
        
    }
    
}
