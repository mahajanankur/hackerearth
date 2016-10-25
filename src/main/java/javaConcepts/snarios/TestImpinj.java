/**
 * 
 */
package javaConcepts.snarios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author amahajan
 *
 * @written Sep 28, 2016
 */
public class TestImpinj {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test1();
		Integer a = 10;
		System.out.println(a.floatValue());
		// List<ImpinjDTO> dtos = new ArrayList<ImpinjDTO>();
		// List<FinalResponse> responseList = new ArrayList<FinalResponse>();
		// dtos.add(new ImpinjDTO("zone1", "1", "aaa", "name"));
		// dtos.add(new ImpinjDTO("zone1", "1", "bbb", "name"));
		// dtos.add(new ImpinjDTO("zone1", "1", "aaa", "name"));
		// dtos.add(new ImpinjDTO("zone2", "1", "ccc", "name"));
		// dtos.add(new ImpinjDTO("zone2", "1", "aaa", "name"));
		// dtos.add(new ImpinjDTO("zone1", "1", "aaa", "name"));
		// dtos.add(new ImpinjDTO("zone2", "1", "aaa", "name"));
		// dtos.add(new ImpinjDTO("zone1", "1", "aaa", "name"));
		// dtos.add(new ImpinjDTO("zone3", "1", "aaa", "name"));
		// dtos.add(new ImpinjDTO("zone1", "1", "aaa", "name"));
		// dtos.add(new ImpinjDTO("zone1", "1", "aaa", "name"));

		// testLembda(dtos);
		// testSet(dtos);

	}

	private static void testSet(List<ImpinjDTO> dtos) {
		Set<ImpinjDTO> unique = new HashSet<ImpinjDTO>(dtos);
		for (ImpinjDTO key : unique) {
			System.out.println(key.getSku() + " Zone " + key.getZone() + ": " + Collections.frequency(dtos, key));
		}

	}

	private static void test1() {
		List<ImpinjDTO> dtos = new ArrayList<ImpinjDTO>();
		List<FinalResponse> responseList = new ArrayList<FinalResponse>();
		dtos.add(new ImpinjDTO("zone1", "1", "aaa", "name1"));
		dtos.add(new ImpinjDTO("zone1", "1", "bbb", "name2"));
		dtos.add(new ImpinjDTO("zone1", "1", "aaa", "name3"));
		dtos.add(new ImpinjDTO("zone2", "1", "ccc", "name4"));
		dtos.add(new ImpinjDTO("zone2", "1", "aaa", "name5"));
		dtos.add(new ImpinjDTO("zone1", "1", "aaa", "name6"));
		dtos.add(new ImpinjDTO("zone2", "1", "aaa", "name7"));
		dtos.add(new ImpinjDTO("zone1", "1", "aaa", "name8"));
		dtos.add(new ImpinjDTO("zone3", "1", "aaa", "name9"));
		dtos.add(new ImpinjDTO("zone1", "1", "aaa", "name10"));
		dtos.add(new ImpinjDTO("zone1", "1", "aaa", "name11"));
		testLembda(dtos);
		for (int i = 0; i < dtos.size(); i++) {
			String sku = dtos.get(i).getSku();
			String zone = dtos.get(i).getZone();
			boolean isExecuted = dtos.get(i).isExecuted();
			if (!isExecuted) {
				int count = 0;
				for (int j = i; j < dtos.size(); j++) {
					ImpinjDTO finalResponse2 = dtos.get(j);
					String sku2 = finalResponse2.getSku();
					String zone2 = finalResponse2.getZone();
					String name = finalResponse2.getName();
					boolean executed = finalResponse2.isExecuted();
					if (sku.equals(sku2) && zone.equals(zone2) && !executed) {
						count++;
						System.out.println(name);
						// dtos.remove(j);
						finalResponse2.setExecuted(true);
					}
				}
				FinalResponse response = new FinalResponse();
				response.setCount(count);
				response.setFloor(dtos.get(i).getFloor());
				response.setName(dtos.get(i).getName());
				response.setSku(sku);
				response.setZone(zone);
				responseList.add(response);
			}
		}
		System.out.println(responseList);
	}

	private static void testLembda(List<ImpinjDTO> dtos) {
		// Map<Object, Long> counts =
		// dtos.stream().collect(Collectors.groupingBy(e -> e,
		// Collectors.counting()));
		// System.out.println(counts);

	}

}
