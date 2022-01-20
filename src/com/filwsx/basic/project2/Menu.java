package com.filwsx.basic.project2;

public class Menu {
	private static int key;
	private static boolean flag = true;
	private static CustomerList customers = new CustomerList(3);
	public static void main(String args[]) {
		while(flag){
			showMenu();
			switch (key) {
				case 1: add();break;
				case 2: change();break;
				case 3: delete();break;
				case 4: list();break;
				case 5: exit();break;
			}
		}
	}
	
	public static void showMenu() {
		System.out.println("\n-----------------客户信息管理软件-----------------\n");
		System.out.println("                   1 添 加 客 户");
		System.out.println("                   2 修 改 客 户");
		System.out.println("                   3 删 除 客 户");
		System.out.println("                   4 客 户 列 表");
		System.out.println("                   5 退       出\n");
		System.out.print("                   请选择(1-5)：");
        key = Reader.readMenuSelection();
        System.out.println();
	}
	
	public static void add() {
		System.out.println("---------------------添加客户---------------------");
		System.out.print("姓名：");
		String name = Reader.readString(8);
		System.out.print("性别：");
		char gender = Reader.readChar();
		System.out.print("年龄：");
		int age = Reader.readAge();
		System.out.print("电话：");
		String phone = Reader.readString(15);
		System.out.print("邮箱：");
		String email = Reader.readString(15);
		Customer cust = new Customer(name, gender, age, phone, email);
		boolean flag = customers.addCustomer(cust);
		if (flag) {
			System.out
					.println("---------------------添加完成---------------------");
		} else {
			System.out.println("----------------记录已满,无法添加-----------------");
		}
	}
	
	//与示例代码差别在于，没考虑空白输入视为不修改
	//readKeyBoard()也i没考虑空白输入情况。
	//但是这样够了。这样了解一边代码，过一段时间在空手完全撸出来。20220119 2303 比看视频快！
	public static void change() {
		System.out.println("---------------------修改客户---------------------");
		int index = 0;
		Customer cust = null;
		for (;;) {
			System.out.print("请选择待修改客户编号(-1退出)：");
			index = Reader.readInt(2);
			if (index == -1) {
				return;
			}
			cust = customers.getCustomer(index - 1);
			if (cust == null) {
				System.out.println("无法找到指定客户！");
			} else
				break;
		}

		System.out.print("姓名(" + cust.getName() + ")：");
		String name = Reader.readString(4);

		System.out.print("性别(" + cust.getGender() + ")：");
		char gender = Reader.readChar();

		System.out.print("年龄(" + cust.getAge() + ")：");
		int age = Reader.readInt(2);

		System.out.print("电话(" + cust.getPhone() + ")：");
		String phone = Reader.readString(15);

		System.out.print("邮箱(" + cust.getEmail() + ")：");
		String email = Reader.readString(15);

		cust = new Customer(name, gender, age, phone, email);

		boolean flag = customers.replaceCustomer(index - 1, cust);
		if (flag) {
			System.out
					.println("---------------------修改完成---------------------");
		} else {
			System.out.println("----------无法找到指定客户,修改失败--------------");
		}
	}
	
	public static void delete() {
		System.out.println("---------------------删除客户---------------------");
		int index = 0;
		Customer cust = null;
		for (;;) {
			System.out.print("请选择待删除客户编号(-1退出)：");
			index = Reader.readInt(2);
			if (index == -1) {
				return;
			}

			cust = customers.getCustomer(index - 1);
			if (cust == null) {
				System.out.println("无法找到指定客户！");
			} else
				break;
		}

		System.out.print("确认是否删除(Y/N)：");
		
		if (Reader.readConfirmSelection())
			return;

		boolean flag = customers.deleteCustomer(index - 1);
		if (flag) {
			System.out
					.println("---------------------删除完成---------------------");
		} else {
			System.out.println("----------无法找到指定客户,删除失败--------------");
		}
	}
	
	public static void list() {
		System.out.println("---------------------------客户列表---------------------------");
        Customer[] custs = customers.getAllCustomers();
        if (custs.length == 0) {
            System.out.println("没有客户记录！");
        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
            for (int i = 0; i < custs.length; i++) {
            	System.out.println((i+1) + "\t" + custs[i].getDetails());
            }
        }
        System.out.println("-------------------------客户列表完成-------------------------");
	}
	
	public static void exit() {
		System.out.print("确认是否退出(Y/N)：");
        flag = Reader.readConfirmSelection();
	}
	
}
