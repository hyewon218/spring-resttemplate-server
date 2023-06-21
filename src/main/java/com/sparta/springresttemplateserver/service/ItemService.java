package com.sparta.springresttemplateserver.service;

import com.sparta.springresttemplateserver.dto.ItemResponseDto;
import com.sparta.springresttemplateserver.dto.UserRequestDto;
import com.sparta.springresttemplateserver.entity.Item;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    private final List<Item> itemList = Arrays.asList(
            new Item("Mac", 3_888_000),
            new Item("iPad", 1_230_000),
            new Item("iPhone", 1_550_000),
            new Item("Watch", 450_000),
            new Item("AirPods", 350_000)
    );

    // 검색에어 맞는지 안 맞는지 체크해서 Item List 에서 찾아서 반환
    public Item getCallObject(String query) {
        for (Item item : itemList) {
            // item.getTitle() : 고정되어 있는 데이터 가지고 온다.( Mac, iPad...)
            // 우리가 받아온 query 랑 비교한다.
            if(item.getTitle().equals(query)) {
                // 일치하는 item 객체를 하나 뽑아서 return 한다.
                return item;
            }
        }
        return null;
    }

    public ItemResponseDto getCallList() {
        ItemResponseDto responseDto = new ItemResponseDto();
        for (Item item : itemList) {
            responseDto.setItems(item);
        }
        return responseDto;
    }

    public Item postCall(String query, UserRequestDto userRequestDto) {
        System.out.println("userRequestDto.getUsername() = " + userRequestDto.getUsername());
        System.out.println("userRequestDto.getPassword() = " + userRequestDto.getPassword());

        // 받아온 query 로 item 하나 가지고 와야함
        return getCallObject(query);
    }

    // 요청에 대한 응답
    public ItemResponseDto exchangeCall(String token, UserRequestDto requestDto) {
        System.out.println("token = " + token);
        System.out.println("requestDto.getUsername() = " + requestDto.getUsername());
        System.out.println("requestDto.getPassword() = " + requestDto.getPassword());

        return getCallList();
    }
}
