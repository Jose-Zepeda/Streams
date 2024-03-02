package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args)
    {

        //Metodo: filter
        //Descripcion: Filtra los elementos de un stream que cumplan con una condicion
        List<String> names = Arrays.asList("Ana", "Juan", "Pedro", "Maria", "Luisa", "Carlos");
        List<String> namesWithA = names.stream().filter(name -> name.contains("a")).collect(Collectors.toList());
        System.out.println(namesWithA);

        //Metodo: map
        //Descripcion: Transforma los elementos de un stream en otros elementos
        List<String> namesUpperCase = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(namesUpperCase);

        //Metodo: flatMap
        //Descripcion: Transforma los elementos de un stream en otros elementos, pero a diferencia de map, flatMap recibe un stream de elementos
        //y devuelve un stream de elementos
        List<List<String>> namesList = Arrays.asList(
                Arrays.asList("Ana", "Juan"),
                Arrays.asList("Pedro", "Maria"),
                Arrays.asList("Luisa", "Carlos")
        );
        List<String> allNames = namesList.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(allNames);

        //Metodo: distinct
        //Descripcion: Elimina los elementos duplicados de un stream
        List<String> namesWithDuplicates = Arrays.asList("Ana", "Juan", "Pedro", "Maria", "Luisa", "Carlos", "Ana", "Juan");
        List<String> uniqueNames = namesWithDuplicates.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueNames);

        //Metodo: sorted
        //Descripcion: Ordena los elementos de un stream
        List<String> namesUnsorted = Arrays.asList("Ana", "Juan", "Pedro", "Maria", "Luisa", "Carlos");
        List<String> namesSorted = namesUnsorted.stream().sorted().collect(Collectors.toList());
        System.out.println(namesSorted);

        //Metodo: limit
        //Descripcion: Limita la cantidad de elementos de un stream
        List<String> namesUnlimited = Arrays.asList("Ana", "Juan", "Pedro");
        List<String> namesLimited = namesUnlimited.stream().limit(2).collect(Collectors.toList());
        System.out.println(namesLimited);

        // Crear una lista de números
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. Filtrar los números pares
        List<Integer> numerosPares = numeros.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Números pares: " + numerosPares);

        // 2. Duplicar cada número
        List<Integer> numerosDuplicados = numeros.stream()
                .map(num -> num * 2)
                .collect(Collectors.toList());
        System.out.println("Números duplicados: " + numerosDuplicados);

        // 3. Reducir (sumar) todos los números
        int sumaTotal = numeros.stream()
                .reduce(0, Integer::sum);
        System.out.println("Suma total: " + sumaTotal);

        // 4. Encontrar el cuadrado del primer número par
        int cuadradoPrimerPar = numeros.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .findFirst()
                .orElse(0);
        System.out.println("Cuadrado del primer número par: " + cuadradoPrimerPar);

        // 5. Verificar si todos los números son mayores que 5
        boolean todosMayoresQueCinco = numeros.stream()
                .allMatch(num -> num > 5);
        System.out.println("¿Todos los números son mayores que 5? " + todosMayoresQueCinco);

        // Ejemplos con tipos de streams adicionales

        // 6. Usar IntStream para calcular la suma de los cuadrados de los números pares
        int sumaCuadradosPares = numeros.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(num -> num * num)
                .sum();
        System.out.println("Suma de los cuadrados de los números pares: " + sumaCuadradosPares + " (IntStream)");

        // 7. Crear un DoubleStream para calcular el promedio de los números
        double promedio = numeros.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
        System.out.println("Promedio de los números: " + promedio + " (DoubleStream)");

        // 8. Usar IntStream para generar los primeros 5 números pares
        List<Integer> primerosCincoPares = IntStream.iterate(2, n -> n + 2)
                .limit(5)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Primeros 5 números pares: " + primerosCincoPares + " (IntStream)");
    }




}