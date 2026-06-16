package application;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

public class ProgramTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.creatSellerDao();
		
		System.out.println("=====TESTE Seller findById=====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=====TESTE Seller findByDepartment=====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=====TESTE seller findAll=====");
		list = sellerDao.findAll();

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=====TESTE seller insert=====");
		Seller newSeller = new Seller(null, "Luan Nogueira", "luan@gmail.com", LocalDate.now(), 4000.0, department);
		sellerDao.insert(newSeller);

		System.out.println("Adicionado! Novo id = " + newSeller.getId());

		System.out.println("\n=====TESTE seller update=====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);

		System.out.println("Atualização realizada com sucesso!");

		System.out.println("\n=====TESTE seller delete=====");
		System.out.print("Digite o ID do vendedor para deletar: ");
		int id = sc.nextInt();

		sellerDao.deleteById(id);

		System.out.println("Deletado com sucesso!");
		
		sc.close();
    }
}
