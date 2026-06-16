package application;

import java.util.List;
import java.util.Scanner;

import dao.DaoFactory;
import dao.DepartmentDao;
import entities.Department;

public class ProgramTest2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=====TESTE findById=====");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=====TESTE findAll=====");
		List<Department> list = departmentDao.findAll();

		for (Department d : list) {
			System.out.println(d);
		}

		System.out.println("\n=====TESTE insert=====");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);

		System.out.println("Adicionado! Novo ID: " + newDepartment.getId());

		System.out.println("\n=====TESTE update=====");
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");

		departmentDao.update(dep2);

		System.out.println("Atualizado com sucesso!");
		
		System.out.println("\n=====TESTE delete=====");
		System.out.print("Digite o ID para deletar: ");
		int id = sc.nextInt();

		departmentDao.deleteById(id);

		System.out.println("Deletado com sucesso!");

        sc.close();
    }
}