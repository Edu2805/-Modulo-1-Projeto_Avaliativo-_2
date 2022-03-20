<h1 align="center"> 🚜 Projeto DEV-Agro 🚜</h1>
<h2 align="center"> 💻 Projeto avaliativo 2 do primeiro módulo back-end do curso DevInHouse Senai / Senior Sistemas. 💻</h2>

<h3 align="center">***********🔧 INSTRUçÕES 🔧***********</h3>
<h4 align="center">Estruturas Json para testes</h4>

```bash
    Cadastro de Empresas

{
    "nome": "Nome da empresa",
    "cnpj": "00.000.000/0000-00",
    "endereco": "Endereco"
}
############################################################
    Cadastro de Funcionarios

{
    "nome": "Nome",
    "sobrenome": "Sobrenome",
    "cpf": "000.000.000-00",
    "endereco": "Endereco",
    "telefone": "(00) 000000000",
    "sexo": "FEMININO",
    "dataNascimento": "0000-00-00",
    "dataAdmissao": "0000-00-00",
    "empresa": {
        "id": 1
    }
}
############################################################
    Cadastro de Grãos

{
    "nome": "Grao",
    "tempoMedioColheita": 0,
    "empresa": {
        "id": 1
    }
}
############################################################
    Cadastro de Fazendas

{
    "nome": "Fazenda",
    "endereco": "Endereco",
    "estoque": 200,
    "ultimaColheita": "0000-00-00",
    "grao": {
        "id": 1
    },
    "empresa": {
        "id": 1
    }
}
############################################################
    Registro de colheita(Entrada de grãos no estoque)

{
    "entradaColheita": 100 
}
############################################################
    Registro de colheita(Saída de grãos no estoque)

{
    "saidaColheita": 100  
} 
```
<h4 align="center">End-Points para testes</h4>
<p><img src="/Users/eduardoamorim/Documents/Programacao/DevInHouse/Spring/Projeto2/devagro/images/Get.png" title="Readme"/>Lista completa de empresas cadastradas</p>
<p>🔗 http://localhost:8080/empresa</p>
<hr>
<p><img src="/Users/eduardoamorim/Documents/Programacao/DevInHouse/Spring/Projeto2/devagro/images/Get.png" title="Readme"/>Lista de fazendas de uma empresa</p>
<p>🔗 http://localhost:8080/fazenda/listarfazendasempresa/{id}</p>
<hr>
<p><img src="/Users/eduardoamorim/Documents/Programacao/DevInHouse/Spring/Projeto2/devagro/images/Get.png" title="Readme"/>Quantidade de fazendas de uma empresa</p>
<p>🔗 http://localhost:8080/fazenda/quantidadefazendas/{id}</p>
<hr>
<p><img src="/Users/eduardoamorim/Documents/Programacao/DevInHouse/Spring/Projeto2/devagro/images/Get.png" title="Readme"/>Lista de fazendas de uma empresa (ID, nome, data previsão colheita, tempo médio de colheita)</p>
<p>🔗 http://localhost:8080/fazenda/listafazendasdetalhadas/{id}</p>
<hr>
<p><img src="/Users/eduardoamorim/Documents/Programacao/DevInHouse/Spring/Projeto2/devagro/images/Put.png" title="Readme"/>Registro de colheita (Entrada de grãos no estoque)</p>
<p>🔗 http://localhost:8080/fazenda/registraentradacolheita/{id}</p>
<hr>
<p><img src="/Users/eduardoamorim/Documents/Programacao/DevInHouse/Spring/Projeto2/devagro/images/Put.png" title="Readme"/>Registro de colheita (Saída de grãos no estoque)</p>
<p>🔗 http://localhost:8080/fazenda/registrasaidacolheita/{id}</p>
<hr>
<p><img src="/Users/eduardoamorim/Documents/Programacao/DevInHouse/Spring/Projeto2/devagro/images/Get.png" title="Readme"/>Lista de grãos de uma empresa</p>
<p>🔗 http://localhost:8080/grao/listargraosempresa/{id}</p>
<hr>
<p><img src="/Users/eduardoamorim/Documents/Programacao/DevInHouse/Spring/Projeto2/devagro/images/Get.png" title="Readme"/>Lista de grãos (nome do grão, quantidade de estoque em ordem ascendente)</p>
<p>🔗 http://localhost:8080/fazenda/estoquegraoscrescente/{id}</p>
<hr>
<p><img src="/Users/eduardoamorim/Documents/Programacao/DevInHouse/Spring/Projeto2/devagro/images/Get.png" title="Readme"/>Lista de funcionários de uma empresa</p>
<p>🔗 http://localhost:8080/funcionario/listarfuncionariosempresa/{id}</p>
<hr>
<p><img src="/Users/eduardoamorim/Documents/Programacao/DevInHouse/Spring/Projeto2/devagro/images/Get.png" title="Readme"/>Quantidade de funcionários de uma empresa</p>
<p>🔗 http://localhost:8080/funcionario/quantidadefuncionarios/{id}</p>
<hr>
<h3 align="center">*********** DETALHES DOS END-POINTS ***********</h3>
<p align="center"><img src="/Users/eduardoamorim/Documents/Programacao/DevInHouse/Spring/Projeto2/devagro/images/RotasHttp.png" title="Readme"/></p>

<h3 align="center">*********** PROPOSTA ORM ***********</h3>
<p align="center"><img src="/Users/eduardoamorim/Documents/Programacao/DevInHouse/Spring/Projeto2/devagro/images/ORMDevAgro.png" title="Readme"/></p>
<h4 align="center"> 🚧 Projeto em construção 🚧</h4>

