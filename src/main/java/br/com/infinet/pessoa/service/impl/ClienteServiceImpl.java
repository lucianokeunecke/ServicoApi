package br.com.infinet.pessoa.service.impl;

import br.com.infinet.pessoa.model.Cep;
import br.com.infinet.pessoa.model.Cliente;
import br.com.infinet.pessoa.repository.ClienteRepository;
import br.com.infinet.pessoa.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void incluir(Cliente cliente) {

        atualizarEndereco(cliente);

        clienteRepository.save(cliente);
    }

    @Override
    public void alterar(Long id, Cliente cliente) {

        Cliente clienteSalvo = clienteRepository.findById(id).orElse(null);

        BeanUtils.copyProperties(cliente, clienteSalvo, "id");

        atualizarEndereco(clienteSalvo);

        clienteRepository.save(clienteSalvo);
    }

    /* Caso o usuário tenha informado o CEP, os campos endereco, bairro, cidade e estado
    * serão preenchidos de forma automatica, com base no retorno da API CEP */
    @Override
    public Cliente atualizarEndereco(Cliente cliente) {

        if (!Objects.isNull(cliente.getCep())) {

            if (cliente.getCep().trim().length() > 0) {

                Cep apiCep = retornarDadosApiCep(cliente.getCep());

                if (!Objects.isNull(apiCep)) {
                    cliente.setEndereco(apiCep.getLogradouro());
                    cliente.setBairro(apiCep.getBairro());
                    cliente.setCidade(apiCep.getLocalidade());
                    cliente.setEstado(apiCep.getUf());
                }
            }
        }
        return cliente;
    }

    @Override
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<Cliente> buscarPeloId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    /* Este método irá consultar a API Cep, passando como parâmetro o número do Cep
    *  e retorando as informações do endereço do CEP. */
    @Override
    public Cep retornarDadosApiCep(String numeroCep) {

        numeroCep = numeroCep.replaceAll("[^0123456789]", "");

        String url = String.format("http://localhost:8081/cep/%s",numeroCep);

        return restTemplate.getForObject(url, Cep.class);
    }

}
