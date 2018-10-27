//package com.ramnar.rest;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ramnar.exception.ResourceNotFoundException;
//import com.ramnar.model.Note;
//import com.ramnar.service.NoteService;
//
//@RestController
//@RequestMapping("/api")
//public class NoteController {
//
//	@Autowired
//	NoteService noteService;
//
//	// Get All Notes
//	@GetMapping("/notes")
//	public List<Note> getAllNotes() {
//		return noteService.getAllNotes();
//	}
//
//	// Create a new Note
//	@PostMapping("/notes")
//	public Note createNote(@Valid @RequestBody Note note) {
//		return noteService.save(note);
//	}
//
//	// Get a Single Note
//	@GetMapping("/notes/{id}")
//	public Note getNoteById(@PathVariable(value = "id") final Long noteId) {
//		Note note = noteService.getNote(noteId);
//		if (note == null) {
//			throw new ResourceNotFoundException("Note", "id", noteId);
//		}
//		return note;
//	}
//
//	// Update a Note
//	@PutMapping("/notes")
//	public Note updateNote(@Valid @RequestBody Note noteDetails) {
//
//		return noteService.udpateNote(noteDetails);
//	}
//
//	// Delete a Note
//	@DeleteMapping("/notes/{id}")
//	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
//		noteService.deleteNote(noteId);
//		return ResponseEntity.ok().build();
//	}
//
//}
