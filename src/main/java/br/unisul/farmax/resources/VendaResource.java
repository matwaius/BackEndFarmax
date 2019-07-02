package br.unisul.farmax.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.farmax.domain.Venda;
import br.unisul.farmax.domain.Produto;
import br.unisul.farmax.domain.Cliente;
import br.unisul.farmax.services.ClienteService;
import br.unisul.farmax.services.ProdutoService;
import br.unisul.farmax.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaResource {
	
	@Autowired
	private VendaService service;
	
	@Autowired
	private ProdutoService prodservice;
	
	@Autowired
	private ClienteService cliservice;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Venda> find(@PathVariable Integer id) {
		Venda obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//INSERIR
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void>insert(@RequestBody Venda obj, @RequestBody Cliente objcli, @RequestBody Produto objprod){
		obj = service.insert(obj);
		
		objcli = cliservice.find(obj.getFk_id_cliente());
		objcli.setSaldo_devedor(objcli.getSaldo_devedor() + obj.getValor());
		objcli = cliservice.update(objcli);
		
		objprod = prodservice.find(obj.getFk_id_produto());
		objprod.setEstoque(objprod.getEstoque() - obj.getQtd_produto());
		objprod = prodservice.update(objprod);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	//ATUALIZAR
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Venda obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

		
	//EXCLUIR
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id, @RequestBody Cliente objcli, @RequestBody Produto objprod) {
		
		Venda obj = new Venda();
		obj = service.find(id);
		
		service.delete(id);
		
		objcli = cliservice.find(obj.getFk_id_cliente());
		objcli.setSaldo_devedor(objcli.getSaldo_devedor() - obj.getValor());
		objcli = cliservice.update(objcli);
		
		objprod = prodservice.find(obj.getFk_id_produto());
		objprod.setEstoque(objprod.getEstoque() + obj.getQtd_produto());
		objprod = prodservice.update(objprod);
		
		return ResponseEntity.noContent().build();
	}

}
