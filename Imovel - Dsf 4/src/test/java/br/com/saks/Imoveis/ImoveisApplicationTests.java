package br.com.saks.Imoveis;


import br.com.saks.Imoveis.Model.Adm;
import br.com.saks.Imoveis.Model.Cliente;
import br.com.saks.Imoveis.Model.Imovel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application.yaml")
class ImoveisApplicationTests {
        
        @Autowired
        private MockMvc mockMvc;
        
        @Autowired
        private ObjectMapper objectMapper;
        
	//CREATE CLIENTE TEST
        @Test
	void createClienteImobiliaria()  throws Exception{
            Cliente cat= new Cliente();
            cat.setNome("Teste 25");
            cat.setEmail("gvkhkjgcdjyg");
            cat.setSenha("ytfyghkj");
            cat.setTelefone("12123132");
            cat.getStatus();
            mockMvc.perform(MockMvcRequestBuilders.post("/cliente")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(cat)))
                    .andExpect(status().isOk());
            
             }
    
        
        //PUT CLIENTE TEST
        @Test
	void putCliente()  throws Exception{
           
            Cliente cat= new Cliente();
            cat.setNome("Teste-Edtidado-1");
            cat.setEmail("gvkhkdafsafajgcdjyg");
            cat.setSenha("ytfygsdsdhkj");
            cat.setTelefone("123132");
            cat.getStatus();
            mockMvc.perform(MockMvcRequestBuilders.put("/cliente/{id}", 1)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(cat)))
                    
                    .andExpect(status().isOk());           
             }
        
        
        
        // GET ID CLIENTE TEST
        @Test
	void getbyCliente()  throws Exception{
            
            mockMvc.perform(MockMvcRequestBuilders.get("/cliente/{id}", 1))
                    
                    .andExpect(status().isOk());
            
             }
        
        // GET TODO CLIENTE TEST
        @Test
	void getallCliente()  throws Exception{
            
            mockMvc.perform(MockMvcRequestBuilders.get("/cliente")
                    .contentType(MediaType.APPLICATION_JSON))
                    
                    .andExpect(status().isOk());           
             }
        
        // DELETAR CLIENTE TEST
         @Test
	void deleteCliente()  throws Exception{
            
            mockMvc.perform(MockMvcRequestBuilders.delete("/cliente/{id}",4))
                  
                    .andExpect(status().isOk());
            
             }
        
        //CREATE ADMINITRADOR TEST
        @Test
	void createAdmImobiliaria()  throws Exception{
            Adm cat= new Adm();
            cat.setNome("Teste");
            cat.setEmail("gvkhkjgcdjyg");
            cat.setSenha("ytfyghkj");
            cat.getStatus();
            mockMvc.perform(MockMvcRequestBuilders.post("/administrador")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(cat)))
                    .andExpect(status().isOk());
            
             }
        
        //PUT ADMINISTRADOR TEST
        @Test
	void putAdm()  throws Exception{
           
            Adm cat= new Adm();
            cat.setNome("Teste-Edtidado");
            cat.setEmail("gvkhkdafsafajgcdjyg");
            cat.setSenha("ytfygsdsdhkj");
            cat.getStatus();
            mockMvc.perform(MockMvcRequestBuilders.put("/administrador/{id}", 1)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(cat)))
                    
                    .andExpect(status().isOk());           
             }
        
        
        //GET ID ADMINISTRADOR TEST
        @Test
	void getbyAdm()  throws Exception{
            
            mockMvc.perform(MockMvcRequestBuilders.get("/administrador/{id}", 1))
                    
                    .andExpect(status().isOk());
            
             }
        
        // GET TODOS ADMINISTRADOR TEST
        @Test
	void getallAdm()  throws Exception{
            
            mockMvc.perform(MockMvcRequestBuilders.get("/administrador")
                    .contentType(MediaType.APPLICATION_JSON))
                    
                    .andExpect(status().isOk());           
             }
        
        //DELETAR ADMIN TEST
        @Test
	void deleteAdm()  throws Exception{
            
            mockMvc.perform(MockMvcRequestBuilders.delete("/administrador/{id}",2))
                  
                    .andExpect(status().isOk());
            
             }
        
        



}
