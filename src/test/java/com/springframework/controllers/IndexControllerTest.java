package com.springframework.controllers;

import com.springframework.domain.Recipe;
import com.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import reactor.core.publisher.Flux;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@Ignore
public class IndexControllerTest {

    //MockMvc mockMvc;
    WebTestClient webTestClient;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    IndexController controller;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new IndexController(recipeService);
        //mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        webTestClient = WebTestClient.bindToController(controller).build();
    }

    @Test
    public void testMockMVC() throws Exception {
        when(recipeService.getRecipes()).thenReturn(Flux.empty());
//        mockMvc.perform(get("/"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("index"));
        webTestClient.get().uri("/")
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }

//    @Test
//    public void getIndexPage() throws Exception {

//        Recipe recipe = new Recipe();
//        recipe.setId("1");
//
//        when(recipeService.getRecipes()).thenReturn(Flux.just(recipe));
//
//        ArgumentCaptor<List<Recipe>> argumentCaptor = ArgumentCaptor.forClass(List.class);
//
//        //when
//        String viewName = controller.getIndexPage(model);
//
//
//        //then
//        assertEquals("index", viewName);
//        verify(recipeService, times(1)).getRecipes();
//        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
//        List<Recipe> setInController = argumentCaptor.getValue();
//        assertEquals(1, setInController.size());
//    }

}