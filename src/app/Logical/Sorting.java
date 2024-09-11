package app.Logical;

import javafx.scene.control.Label;

public class Sorting {    

    public static String vetorParaString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    // Selection Sort
    public static void selectionSort(int[] array, Label timeLabel, Label tradeLabel) {
        int swapCount = 0; // Contador de trocas
        long startTime = System.currentTimeMillis(); // Início da medição de tempo
    
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // Troca dos elementos
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
                swapCount++; // Incrementa o contador de trocas
            }
        }
    
        long endTime = System.currentTimeMillis(); // Fim da medição de tempo
        long duration = endTime - startTime; // Duração da execução
    
        // Saída no console para verificação
        System.out.println("Número de trocas: " + swapCount);
        System.out.println("Tempo de execução: " + duration + " ms");
    
        // Atualizar os labels
        if (timeLabel != null) {
            timeLabel.setText(String.valueOf(duration));
        }
        if (tradeLabel != null) {
            tradeLabel.setText(String.valueOf(swapCount));
        }
    }

    // HeapSort
    public static void heapsort(int[] array, Label timeLabel, Label tradeLabel) {
        int n = array.length;
        int swapCount = 0;
        long startTime = System.currentTimeMillis();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            swapCount++;
            heapify(array, i, 0);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Número de trocas: " + swapCount);
        System.out.println("Tempo de execução: " + duration + " ms");

        timeLabel.setText(String.valueOf(duration));
        tradeLabel.setText(String.valueOf(swapCount));
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largest]) {
            largest = l;
        }

        if (r < n && array[r] > array[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(array, n, largest);
        }
    }

    // Insertion Sort
    public static void insertionSort(int[] array, Label timeLabel, Label tradeLabel) {
        int n = array.length;
        int swapCount = 0; // Contador de movimentações
        long startTime = System.currentTimeMillis();
    
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
    
            // Move os elementos do array que são maiores que a chave para uma posição à frente
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                swapCount++; // Contador de movimentações
            }
            array[j + 1] = key;
        }
    
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
    
        // Saída no console para verificação
        System.out.println("Número de movimentações: " + swapCount);
        System.out.println("Tempo de execução: " + duration + " ms");
    
        // Atualizar os labels
        if (timeLabel != null) {
            timeLabel.setText(String.valueOf(duration));
        }
        if (tradeLabel != null) {
            tradeLabel.setText(String.valueOf(swapCount));
        }
    }

    // ShellSort
    public static void shellSort(int[] array, Label timeLabel, Label tradeLabel) {
        int n = array.length;
        int swapCount = 0; // Contador de movimentações
        long startTime = System.currentTimeMillis();
    
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > key) {
                    array[j] = array[j - gap];
                    j -= gap;
                    swapCount++; // Contador de movimentações
                }
                array[j] = key;
            }
        }
    
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
    
        // Saída no console para verificação
        System.out.println("Número de movimentações: " + swapCount);
        System.out.println("Tempo de execução: " + duration + " ms");
    
        // Atualizar os labels
        if (timeLabel != null) {
            timeLabel.setText(String.valueOf(duration));
        }
        if (tradeLabel != null) {
            tradeLabel.setText(String.valueOf(swapCount));
        }
    }

    // BubbleSort
    public static void bubbleSort(int[] array, Label timeLabel, Label tradeLabel) {
        int n = array.length;
        int swapCount = 0; // Adicionado para contar as trocas
        long startTime = System.currentTimeMillis();

        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                    swapCount++; // Incrementa o contador de trocas
                }
            }
            n--;
        } while (swapped);

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Número de trocas: " + swapCount);
        System.out.println("Tempo de execução: " + duration + " ms");

        timeLabel.setText(String.valueOf(duration));
        tradeLabel.setText(String.valueOf(swapCount));
    }

    // QuickSort
    public static void quickSort(int[] array, Label timeLabel, Label tradeLabel) {
        int[] swapCountHolder = new int[1]; // Usado para manter o contador de trocas
        long startTime = System.currentTimeMillis();
    
        quickSortHelper(array, 0, array.length - 1, swapCountHolder);
    
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
    
        System.out.println("Número de trocas: " + swapCountHolder[0]);
        System.out.println("Tempo de execução: " + duration + " ms");
    
        // Atualizar os labels
        if (timeLabel != null) {
            timeLabel.setText(String.valueOf(duration));
        }
        if (tradeLabel != null) {
            tradeLabel.setText(String.valueOf(swapCountHolder[0]));
        }
    }
    
    // Método auxiliar para Quick Sort
    private static void quickSortHelper(int[] array, int low, int high, int[] swapCountHolder) {
        if (low < high) {
            int pi = partition(array, low, high, swapCountHolder);
            quickSortHelper(array, low, pi - 1, swapCountHolder);
            quickSortHelper(array, pi + 1, high, swapCountHolder);
        }
    }
    
    // Método para particionar o array
    private static int partition(int[] array, int low, int high, int[] swapCountHolder) {
        int pivot = array[high];
        int i = (low - 1); // Índice do menor elemento
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Trocar array[i] e array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                swapCountHolder[0]++; // Incrementa o contador de trocas
            }
        }
        // Trocar array[i + 1] e array[high] (ou seja, o pivô)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        swapCountHolder[0]++; // Incrementa o contador de trocas
        return i + 1;
    }
    
    // Shaker Sort
    public static void shakerSort(int[] array, Label timeLabel, Label tradeLabel) {
        int n = array.length;
        int swapCount = 0;
        long startTime = System.currentTimeMillis();

        boolean swapped = true;
        int start = 0;
        int end = n - 1;

        while (swapped) {
            swapped = false;
            // Move da esquerda para a direita
            for (int i = start; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapCount++;
                    swapped = true;
                }
            }
            end--;

            // Se não houve trocas, a ordenação foi concluída
            if (!swapped) break;

            swapped = false;
            // Move da direita para a esquerda
            for (int i = end; i > start; i--) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapCount++;
                    swapped = true;
                }
            }
            start++;
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Número de trocas: " + swapCount);
        System.out.println("Tempo de execução: " + duration + " ms");

        timeLabel.setText(String.valueOf(duration));
        tradeLabel.setText(String.valueOf(swapCount));
    }
}
