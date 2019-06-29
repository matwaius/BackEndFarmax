package br.unisul.farmax.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.farmax.services.ProdutoService;
import br.unisul.farmax.domain.Produto;
import br.unisul.farmax.dtos.ProdutoDTO;
import br.unisul.farmax.resources.Utils.URL;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		Produto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//INSERIR
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Produto obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	//ATUALIZAR
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Produto obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<Produto> list = service.findAll();
		List<ProdutoDTO> listDto = new ArrayList<ProdutoDTO>();
		for (Produto c : list) {
			listDto.add(new ProdutoDTO(c));
		}
		return ResponseEntity.ok().body(listDto);
	}

		
	//EXCLUIR
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//FILTRAR POR NOME
	@RequestMapping(value="/filtro",method=RequestMethod.GET)
	public ResponseEntity<List<ProdutoDTO>> filtrarPorNome(
			@RequestParam(value = "nome", defaultValue = "") String nome
			) {
			String nomeDecoded = URL.decodeParam(nome);
			List<Produto> lista = service.buscaPorNome(nomeDecoded);
			List<ProdutoDTO> listaDTO = lista.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList()); 
			return ResponseEntity.ok().body(listaDTO);
		}

}
