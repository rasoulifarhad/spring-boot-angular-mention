package com.farhad.example.springbootangularngzorromention.person.jpa.utils;

import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;

import com.farhad.example.springbootangularngzorromention.person.controller.model.paging.PageInfo;
import com.farhad.example.springbootangularngzorromention.person.controller.model.paging.Sorting;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PageInfoMapper {
	
	public PageRequest toPageRequest(PageInfo pageInfo) {
		return pageInfo.getSort() != null ? PageRequest.of(pageInfo.getPageNumber() -1 , 
															pageInfo.getPageSize(),
															Sort.by(mapToOrders(pageInfo.getSort())))
										  : PageRequest.of(pageInfo.getPageNumber() -1 , 
															pageInfo.getPageSize()
															);
	}

	private List<Sort.Order> mapToOrders(List<Sorting> sortingList) {
		return CollectionUtils.isEmpty(sortingList) ? Collections.emptyList() :
					sortingList.stream()
							ma
	}

	private Sort.Order toOrder(Sorting sorting) {
		return new Order(Sort.Direction.fromString(sorting.getOrder().name()), sorting.getColumn());
	}
}
