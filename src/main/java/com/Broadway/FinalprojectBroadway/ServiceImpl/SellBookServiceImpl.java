package com.Broadway.FinalprojectBroadway.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Broadway.FinalprojectBroadway.Model.SellBook;
import com.Broadway.FinalprojectBroadway.Repository.SellBookRepository;
import com.Broadway.FinalprojectBroadway.Service.SellBookService;

@Service
public class SellBookServiceImpl implements SellBookService{
    @Autowired
	private SellBookRepository sellRepo;
	
	
	@Override
	public void sellBook(SellBook book) {
		
		sellRepo.save(book);
	}

}
