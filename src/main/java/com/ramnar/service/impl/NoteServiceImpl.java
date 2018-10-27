///**
// * 
// */
//package com.ramnar.service.impl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ramnar.model.Note;
//import com.ramnar.repository.NoteRepository;
//import com.ramnar.service.NoteService;
//
//@Service
//public class NoteServiceImpl implements NoteService {
//	
//	@Autowired
//	private NoteRepository repository;
//	@Override
//	public List<Note> getAllNotes() {
//		return repository.findAll();
//	}
//	@Override
//	public Note save(Note note) {
//		return repository.save(note);
//	}
//	
//	@Override
//	public Note udpateNote(Note note) {
//		return repository.save(note);
//	}
//	
//	@Override
//	public Note getNote(Long id) {
//		Optional<Note> note = repository.findById(id);
//		if(note.isPresent()) {
//			return note.get();
//		}else {
//			return null;
//		}
//	}
//	
//	@Override
//	public void deleteNote(Long id) {
//		repository.deleteById(id);
//	}
//
//}
