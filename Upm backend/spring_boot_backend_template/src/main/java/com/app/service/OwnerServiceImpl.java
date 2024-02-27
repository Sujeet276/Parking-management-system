package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.Dto.FlatDto;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.FlatDao;
import com.app.dao.OwnerDao;
import com.app.entities.Flat;
import com.app.entities.Image;
import com.app.entities.Owner;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerDao ownerDao;

	@Autowired
	private FlatDao flatDao;

	@Autowired
	private ModelMapper mapper;

	public List<Owner> ownerList() {
		return ownerDao.findAll();
	}

	@Override
	public String addImage(MultipartFile[] image, long id) {
		Flat flat = flatDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("flat Not found!!"));
		try {
			for (MultipartFile img : image) {
				flat.addImage(new Image(img.getBytes()));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "Image inserted Successfully";
	}

	@Override
	public String addFlat(FlatDto flatDto, MultipartFile[] image) {

		Owner owner = ownerDao.findByEmailId(SecurityContextHolder.getContext().getAuthentication().getName())
				.orElseThrow();
		Flat flat = mapper.map(flatDto, Flat.class);
		try {
			for (MultipartFile img : image) {
				flat.addImage(new Image(img.getBytes()));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		owner.addFlat(flat);
		return "details inserted successfully";
	}

	@Override
	public List<Image> getImage(long id) {
		Flat flat = flatDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("flat Not found!!"));
		System.out.println(flat.getImageList().size());
		return flat.getImageList();
	}

	@Override
	public List<Flat> flatList() {
		Owner owner = ownerDao.findByEmailId(SecurityContextHolder.getContext().getAuthentication().getName())
				.orElseThrow();
		System.out.println("owner flat size:"+owner.getList().size());
		return owner.getList();
	}

	@Override
	public Owner updateOwner(Owner owner) {
		  return ownerDao.save(owner);
	}

}
