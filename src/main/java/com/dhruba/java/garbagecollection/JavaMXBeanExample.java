package com.dhruba.java.garbagecollection;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.List;

public class JavaMXBeanExample {

	public static void main(String[] args) {
		List<GarbageCollectorMXBean> garbageCollectorBeans = ManagementFactory.getGarbageCollectorMXBeans();

		// garbage collection bean details
		garbageCollectorBeans.stream().forEach(garbageCollectorBean -> {
			System.out.println("Garbage Collection Bean Name = " + garbageCollectorBean.getName());
			System.out.println("CollectionTime = " + garbageCollectorBean.getCollectionTime() + " ms");
			System.out.println("CollectionCount = " + garbageCollectorBean.getCollectionCount());
			Arrays.asList(garbageCollectorBean.getMemoryPoolNames()).stream().forEach(memoryPoolName -> {
				System.out.println("  Memory pool name = " + memoryPoolName);
			});
			System.out.println("\n");
		});
	}
}
