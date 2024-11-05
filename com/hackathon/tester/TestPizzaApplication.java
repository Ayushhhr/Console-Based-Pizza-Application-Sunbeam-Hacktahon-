package com.hackathon.tester;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.hackathon.dao.ItemDao;
import com.hackathon.dao.ItemPriceDao;
import com.hackathon.dao.OrderDao;
import com.hackathon.dao.UserDao;
import com.hackathon.entities.Customer;
import com.hackathon.entities.ItemPrice;

public class TestPizzaApplication 
{

	
	static int topMenu(Scanner sc)
	{
		System.out.println("0. EXIT");
		System.out.println("1. SignIn");
		System.out.println("2. SignUp");
		
		return sc.nextInt();
	}
	static void registerUser(Scanner sc)
	{
		Customer c = new Customer();
		
		System.out.print("Enter Name: ");
		c.setName(sc.next());
		System.out.print("Enter Password: ");
		c.setPassword(sc.next());
		System.out.print("Enter Mobile: ");
		c.setMobile(sc.next());
		System.out.print("Enter Address: ");
		c.setAddress(sc.next());
		System.out.print("Enter Email: ");
		c.setEmail(sc.next());
	
		try(UserDao userDao = new UserDao())
		{
			userDao.userRegistration(c);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}	
	}
	static Customer signIn(Scanner sc)
	{
		Customer c = new Customer();
		Customer user = null;
		
		System.out.print("Enter Email: ");
		c.setEmail(sc.next());
		System.out.print("Enter Password: ");
		c.setPassword(sc.next());
		
		try(UserDao userDao = new UserDao())
		{
			user = userDao.userLogin(c);
			return user;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}	
		return user;
	}
	static void showAllOrders()
	{
		try(OrderDao orderDao = new OrderDao())
		{
			orderDao.displayOrders();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}	
	}
	static void showOrderDetailsById(Scanner sc)
	{
		try(OrderDao orderDao = new OrderDao())
		{
			System.out.println("Enter Id: ");
			int id = sc.nextInt();
			orderDao.displayOrdersById(id);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}	
	}
	static void adminMenu(Scanner sc)
	{
		int choice = 0;
		do
		{
			System.out.println("0. Exit");
			System.out.println("1. Show All Orders");
			System.out.println("2. Show Order Details For Given Order Id");
			System.out.println("3. Sign Out");
			System.out.println("Enter your choice: ");
			
			
			choice = sc.nextInt();
			
			
			switch(choice)
			{
				case 1:
					
					showAllOrders();
					System.out.println("inside tester");
					break;
					
				case 2:
					
					showOrderDetailsById(sc);
					break;
					
				case 3:
					choice = 0;
					break;
					
				default:
					System.out.println("Invalid Input..");
					break;
			}
		}while(choice != 0);
	}
	
	static void showVegMenu()
	{
		try(ItemDao itemDao = new ItemDao())
		{
			itemDao.displayVegMenu();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}	
	}
	static void showNonVegMenu()
	{
		try(ItemDao itemDao = new ItemDao())
		{
			itemDao.displayNonVegMenu();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}	
	}
	static void showAvailableSizes(Scanner sc)
	{
		try(ItemDao itemDao = new ItemDao())
		{
			System.out.println("Enter Id: ");
			itemDao.displayAvailableSizes(sc.nextInt());
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}	
	}
	
	static void addToCart(Scanner sc, List<ItemPrice> cart)
	{
		try(ItemPriceDao itemPriceDao = new ItemPriceDao())
		{
			System.out.println("Enter Id: ");
			ItemPrice itemDetails = itemPriceDao.getPriceById(sc.nextInt());
			
			if(itemDetails != null)
			{
				cart.add(itemDetails);
				System.out.println("Item Added...");
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e1) 
		{
			e1.printStackTrace();
		}	
		
	}
	
	static void showCart(List<ItemPrice> cart)
	{
		cart.forEach(System.out::println);
	}
	
	static void customerMenu(Scanner sc)
	{
		int choice = 0;
		List<ItemPrice> cart = new ArrayList<ItemPrice>();
		do
		{
			System.out.println("0. Exit");
			System.out.println("1. Show Veg Menu");
			System.out.println("2. Show Non-Veg Menu");
			System.out.println("3. Show Available Sizes by Id");
			System.out.println("4. Add to Cart for Given Price Id");
			System.out.println("5. Show Cart(Pizza With Size and Price Details)");
			System.out.println("6. Place Order(Save Order in Db For Current Customer)");
			System.out.println("7. Sign Out");
			System.out.println("Enter your choice: ");
			
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					
					showVegMenu();
					break;
					
				case 2:
					
					showNonVegMenu();
					break;
					
				case 3:
					showAvailableSizes(sc);
					break;
					
				case 4:
					
					addToCart(sc,cart);
					
					break;
					
				case 5:
					
					showCart(cart);
					
					break;
					
				case 6:
					
					
					break;
				
				case 7:
					choice = 0;
					break;
					
				default:
					System.out.println("Invalid Input..");
					break;
			}
		}while(choice != 0);
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int choice;
		choice = topMenu(sc);
		
		do
		{
			switch(choice)
			{
				case 1:
					try
					{
						if(signIn(sc).getName().equals("admin" ))
							adminMenu(sc);
						else 
							customerMenu(sc);
					}
					catch(Exception e)
					{
						System.out.println("User not found");
					}
					
					break;
					
				case 2:
					registerUser(sc);
					break;
					
				default:
					System.out.println("Invalid Choice..");
					break;
			}
			
		}while( (choice = topMenu(sc)) != 0 );
		System.out.println("Thank you for Using the Application :)");	
	}

}
//select c.name, c.mobile, od.id as OrderDetailsID,o.id as OrderID, i.name,i.type,i.category,i.description from pizza_orderdetails od , pizza_orders o, pizza_items i, pizza_customers c
//where od.OrderId = o.CustomerId AND od.PriceId = i.id having OrderID = 2;
