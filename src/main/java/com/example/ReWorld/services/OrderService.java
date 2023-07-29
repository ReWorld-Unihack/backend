package com.example.ReWorld.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReWorld.entities.Order;
import com.example.ReWorld.entities.OrderStatus;
import com.example.ReWorld.entities.Pet;
import com.example.ReWorld.entities.ServicePackage;
import com.example.ReWorld.models.OrderDTO;
import com.example.ReWorld.repo.IAnimalRepo;
import com.example.ReWorld.repo.IOrderRepo;
import com.example.ReWorld.repo.IPetRepo;
import com.example.ReWorld.repo.IServicePackageRepo;
import com.example.ReWorld.security.repositories.IUserRepository;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private IOrderRepo orderRepo;

	@Autowired
	private IPetRepo petRepo;

	@Autowired
	private IAnimalRepo animalRepo;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IServicePackageRepo packageRepo;

	@Override
	public Order createOrder(OrderDTO orderDTO, Integer userID) {
		Order order = new Order();
		Pet pet = new Pet();
		pet.setAnimal(animalRepo.findById(orderDTO.getAnimalId()).orElse(null));
		pet.setBirthDate(orderDTO.getBirthDate());
		pet.setDeathDate(orderDTO.getDeathDate());
		pet.setName(orderDTO.getName());
		pet.setSpecies(orderDTO.getName());
		pet.setWeight(orderDTO.getWeight());

		order.setPet(petRepo.save(pet));
		order.setMessage(orderDTO.getMessage());
		order.setUser(userRepository.findById(userID).orElse(null));

		ServicePackage service = packageRepo.findById(orderDTO.getServiceId()).orElse(null);
		order.setService(service);

		Integer money = service.getPrice();
		if (orderDTO.getWeight() > 5) {
			money += (int) Math.floor((orderDTO.getWeight() - 5) * 50000);
		}
		OrderStatus orderStatus = new OrderStatus();
		orderStatus.setMessage("Bạn đã đặt dịch vụ "+orderDTO.getName()+". "+
				"Đơn hàng đã gửi đến người quản lí của chúng tôi, vui lòng chờ phản hồi và nhận liên lạc qua điện thoại"
				+ " hoặc tin nhắn mail.Số tiền tạm tính cho dịch vụ bạn đặt là "
						+ money);
		orderStatus.setStatus("Chờ xử lý");
		orderStatus.setOrder(order);
		orderStatus.setDate(LocalDateTime.now());
		order.setOrderStatus(orderStatus);
		order.setPayment(null);
		order.setTotal(money);
		order.setOrderDate(LocalDateTime.now());
		return orderRepo.save(order);
	}

	@Override
	public List<Order> findAll() {
		return orderRepo.findAll();
	}

	@Override
	public List<Order> historyOrder(Integer userId) {
		return orderRepo.findByUserId(userId);
	}

}
