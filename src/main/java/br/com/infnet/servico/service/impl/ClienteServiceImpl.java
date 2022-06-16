package br.com.infnet.servico.service.impl;

import br.com.infnet.servico.model.Cep;
import br.com.infnet.servico.model.Cliente;
import br.com.infnet.servico.repository.ClienteRepository;
import br.com.infnet.servico.service.CepService;
import br.com.infnet.servico.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    CepService cepService;

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

    /* Caso o usuário tenha informado o número do CEP, os campos endereco, bairro, cidade e estado
    * serão preenchidos de forma automática, com base no retorno da API CEP */
    @Override
    public Cliente atualizarEndereco(Cliente cliente) {

        if (!Objects.isNull(cliente.getCep())) {
            if (cliente.getCep().trim().length() > 0) {
                Cep cep = cepService.pesquisar(cliente.getCep());

                if (cep.getLogradouro().trim().length() > 0) {
                    cliente.setEndereco(cep.getLogradouro());
                }
                if (cep.getBairro().trim().length() > 0){
                    cliente.setBairro(cep.getBairro());
                }
                cliente.setCidade(cep.getLocalidade());
                cliente.setEstado(cep.getUf());
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

}
