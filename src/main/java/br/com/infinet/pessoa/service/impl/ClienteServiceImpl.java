package br.com.infinet.pessoa.service.impl;

import br.com.infinet.pessoa.model.Cep;
import br.com.infinet.pessoa.model.Cliente;
import br.com.infinet.pessoa.repository.ClienteRepository;
import br.com.infinet.pessoa.service.CepService;
import br.com.infinet.pessoa.service.ClienteService;
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

    /* Caso o usuário tenha informado o CEP, os campos endereco, bairro, cidade e estado
    * serão preenchidos de forma automatica, com base no retorno da API CEP */
    @Override
    public Cliente atualizarEndereco(Cliente cliente) {

        if (!Objects.isNull(cliente.getCep())) {

            String numeroCep = cliente.getCep().replaceAll("[^0123456789]", "");

            if (numeroCep.trim().length() > 0) {

                if (numeroCep.trim().length() == 8) {

                    Cep apiCep = cepService.pesquisar(numeroCep);

                    if (!Objects.isNull(apiCep)) {

                        if (!Objects.isNull(apiCep.getCep())) {
                            cliente.setEndereco(apiCep.getLogradouro());
                            cliente.setBairro(apiCep.getBairro());
                            cliente.setCidade(apiCep.getLocalidade());
                            cliente.setEstado(apiCep.getUf());
                        } else{
                            throw new RuntimeException("O número do CEP " + numeroCep + " não se encontra cadastrado.");
                        }
                    } else{
                        throw new RuntimeException("O número do CEP " + numeroCep + " não se encontra cadastrado.");
                    }
                } else {
                    throw new RuntimeException("Número do CEP inválido. Informe os 8 dígitos numéricos.");
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

}
