package com.api.mercado.contollers;

import com.api.mercado.dtos.CarrinhoDto;
import com.api.mercado.models.CarrinhoModel;
import com.api.mercado.services.CarrinhoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/carrinho")
public class CarrinhoController {

    final CarrinhoService carrinhoService;

    public CarrinhoController (CarrinhoService carrinhoService){
        this.carrinhoService = carrinhoService;
    }

    @PostMapping
    public ResponseEntity<Object> criarCarrinho(){
        return ResponseEntity.status(HttpStatus.CREATED).body(carrinhoService.criarCarrinho());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> colocarProdutosCarrinho(@PathVariable(value = "id") UUID id, @RequestBody CarrinhoDto carrinhoDto){
        Optional<CarrinhoModel> carrinhoModelOptional = carrinhoService.buscarCarrinhoPorId(id);
        if(carrinhoModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrinho não encontrado.");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(carrinhoService.adicionarProdutos(carrinhoModelOptional.get(), carrinhoDto.getIdProduto(), carrinhoDto.getQuantidade()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable(value = "id") UUID id){
        Optional<CarrinhoModel> carrinhoModelOptional = carrinhoService.buscarCarrinhoPorId(id);
        if(carrinhoModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carrinho não encontrado.");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(carrinhoModelOptional);
        }
    }

}
