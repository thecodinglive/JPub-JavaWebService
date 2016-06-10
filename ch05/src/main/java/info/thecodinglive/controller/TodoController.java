package info.thecodinglive.controller;

import info.thecodinglive.model.ResourceWithUrl;
import info.thecodinglive.model.Todo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/todos")
@Api(value = "todo", description = "todo api")
public class TodoController {
        private Set<Todo> todos = new HashSet<>();

        @ApiOperation(value = "전체 목록을 가져온다.")
        @RequestMapping(method = GET)
        public HttpEntity<Collection<ResourceWithUrl>> listAll() {
            List<ResourceWithUrl> resourceWithUrls = todos.stream().map(todo -> toResource(todo)).collect(Collectors.toList());
            return new ResponseEntity<>(resourceWithUrls, OK);
        }

        @RequestMapping(value = "/{todo-id}", method = GET)
        public HttpEntity<ResourceWithUrl> getTodo(@PathVariable("todo-id") long id) {

            Optional<Todo> todoOptional = tryToFindById(id);

            if (!todoOptional.isPresent())
                return new ResponseEntity<>(NOT_FOUND);

            return respondWithResource(todoOptional.get(), OK);
        }

        private Optional<Todo> tryToFindById(long id) {
            return todos.stream().filter(todo -> todo.getId() == id).findFirst();
        }

        @RequestMapping(method = POST,  headers = {"Content-type=application/json"})
        public HttpEntity<ResourceWithUrl> saveTodo(@RequestBody Todo todo) {
            todo.setId(todos.size() + 1);
            todos.add(todo);

            return respondWithResource(todo, CREATED);
        }

        @RequestMapping(method = DELETE)
        public void deleteAllTodos() {
            todos.clear();
        }

        @RequestMapping(value = "/{todo-id}", method = DELETE)
        public void deleteOneTodo(@PathVariable("todo-id") long id) {
            Optional<Todo> todoOptional = tryToFindById(id);

            if ( todoOptional.isPresent() ) {
                todos.remove(todoOptional.get());
            }
        }

        @RequestMapping(value = "/{todo-id}", method = PATCH, headers = {"Content-type=application/json"})
        public HttpEntity<ResourceWithUrl> updateTodo(@PathVariable("todo-id") long id, @RequestBody Todo newTodo) {
            Optional<Todo> todoOptional = tryToFindById(id);

            if ( !todoOptional.isPresent() ) {
                return new ResponseEntity<>(NOT_FOUND);
            } else if ( newTodo == null ) {
                return new ResponseEntity<>(BAD_REQUEST);
            }

            todos.remove(todoOptional.get());

            Todo mergedTodo = todoOptional.get().merge(newTodo);
            todos.add(mergedTodo);

            return respondWithResource(mergedTodo, OK);
        }


        private String getHref(Todo todo) {
            return linkTo(methodOn(this.getClass()).getTodo(todo.getId())).withSelfRel().getHref();
        }

        private ResourceWithUrl toResource(Todo todo) {
            return new ResourceWithUrl(todo, getHref(todo));
        }

        private HttpEntity<ResourceWithUrl> respondWithResource(Todo todo, HttpStatus statusCode) {
            ResourceWithUrl resourceWithUrl = toResource(todo);

            return new ResponseEntity<>(resourceWithUrl, statusCode);
        }
}
