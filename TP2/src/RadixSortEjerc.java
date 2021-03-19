import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class RadixSortEjerc
{
	public static void radixSort(int []arr)
	{
		// Creamos gestor de strings
		StringUtil su = new StringUtil();
		// Formateamos el arreglo original
		String[] arrStr = su.toStringArray(arr);
		su.lNormalize(arrStr, '0');

		// Creamos mapa para implementar algoritmo
		SortedMap<Character, ArrayList<String>> treeMap = new TreeMap<Character, ArrayList<String>>();
		// Obtenemos la longitud de cada palabra
		int longitud = arrStr[0].length();
		for (int i = longitud - 1; i >= 0; i--) {
			for (int j = 0; j < arrStr.length; j++) {
				// Tomamos el char de la palabra
				char c = arrStr[j].charAt(i);
				// Consultamos si existe ese char en el diccionario
				if (treeMap.get(c) != null) {
					// Si existe agregamos al final de la lsita
					treeMap.get(c).add(arrStr[j]);
				} else {
					// Si no existe creamos la lista y la asignamos a la key
					treeMap.put(c, new ArrayList<String>());
					treeMap.get(c).add(arrStr[j]);
				}
			}
			// Restauramos arreglo original
			String[] newArr = new String[arrStr.length];
			int lastIndex = 0;
			// Recorremos las entries del treemap
			for(Map.Entry<Character,ArrayList<String>> entry:treeMap.entrySet()) {
				// Y en cada entrie recorremos la lista
				ArrayList<String> listValue = entry.getValue();
				for (int k = 0; k < listValue.size(); k++) {
					// Agregamos cada valor al arreglo
					newArr[lastIndex] = listValue.get(k);
					lastIndex++;
				}
			}
			treeMap = new TreeMap<Character, ArrayList<String>>();
			arrStr = newArr;
		}
		for(int i=0; i<arrStr.length;i++)
		{
			System.out.print(arrStr[i]+(i<arrStr.length-1?",":""));
		}
	}

	public static void main(String[] args)
	{
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}
		System.out.println();
		radixSort(arr);
	}
}
