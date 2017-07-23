package design_model.facade; 
/** 
 * @Description: 
 * @Create on: 2015-2-26 下午04:36:26
 * @Author:李欣
 * @Version:1.0
 */
public class Computer {
	
	private Cpu cpu;
	private Disk disk;
	private Memory memory;
	
	public Computer() {
		cpu = new Cpu();
		disk = new Disk();
		memory = new Memory();
	}
	public void startUp(){
		System.out.println("Computer startUp....");
		cpu.startUp();
		disk.startUp();
		memory.startUp();
		System.out.println("Computer startUp finish");
	}
	public void shutDown(){
		System.out.println("Computer shutDown.....");
		cpu.shutDown();
		disk.shutDown();
		memory.shutDown();
		System.out.println("Computer shutDown finish");
	}	
	
}
 