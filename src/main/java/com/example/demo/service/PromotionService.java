package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.*;

@Service
public class PromotionService extends GeneralService<Promotion> {
	
	@Override
    public Promotion update(Promotion promotion, long id){
		promotion.setId(id);
        return repository.saveAndFlush(promotion);
    }
}
