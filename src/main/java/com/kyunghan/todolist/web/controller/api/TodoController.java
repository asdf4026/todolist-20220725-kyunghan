package com.kyunghan.todolist.web.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyunghan.todolist.service.todo.TodoService;
import com.kyunghan.todolist.web.dto.CMRespDto;
import com.kyunghan.todolist.web.dto.todo.CreateTodoReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/todolist")
@RequiredArgsConstructor
public class TodoController {
	
	private final TodoService todoService;
	
	@PostMapping("/todo")
	public ResponseEntity<?> addcontent(@RequestBody CreateTodoReqDto createTodoReqDto){
		try {
			todoService.createTodo(createTodoReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1 , "Adding todo faild" , createTodoReqDto));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1 , "Adding todo success" , createTodoReqDto));
	}
}
