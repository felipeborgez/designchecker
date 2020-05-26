# PseudoCódigo API - Para os Testes dos Exercícios

## DÚVIDA

* O Assert poderia estar encapsulado na API?
* 

## CASOS

**DC um apelido para DesignChecker (um nome fictício)*

Para verificar se uma classe existe:

```java
function existemClassesParaOsQuatroTiposDeProduto(){
	AssertNotFalse(DC.getClass("Bermuda"));
  // or
  AssertTrue(DC.classExists(["Bermuda", "Camisa", "Geladeira", "Liquidificador"]));
  //	or 
  AssertTrue(DC.classExists("Bermuda"));
  AssertTrue(DC.classExists("Camisa"));
  AssertTrue(DC.classExists("Geladeira"));
  AssertTrue(DC.classExists("Liquidificador")); 
}
```



Verifica qual é a super classe ou sub classe:

```java
function existemClassesParaOsQuatroTiposDeProduto(){
	AssertTrue(DC.isSuperclassOf("Eletrodomestico", "Liquidificador"));	
  // or 
  AssertTrue(DC.isSubclassOf("Liquidificador", "Eletrodomestico"));
  // or
  AssertTrue(DC.getClass("Liquidificador").extends("Eletrodomestico"));
}
```

Verifica se tem atributos:

```java
function asClassesContemOsAtributosCorretos(){
  AssertTrue(DC.classHasAttribute("Produto", "preco"));
  AssertTrue(DC.classHasAttribute("Roupa", "cor"));
  AssertTrue(DC.classHasAttribute("Bermuda", "estilo"));
  AssertTrue(DC.classHasAttribute("Camisa", "gola"));
  //or
  AssertTrue(DC.getClass("Eletrodomestico").hasAttribute("voltagem"));
  AssertTrue(DC.getClass("Geladeira").hasAttribute("litros"));
  AssertTrue(DC.getClass("Liquidificador").hasAttribute("potencia"));

  // Pensando verificar classes com dois atributos ou mais
	AssertTrue(DC.classHasAttribute("Roupa", ["cor", "preco"]);
	AssertTrue(DC.getClass("Roupa").hasAttribute(["cor", "preco"]));
}

```

Quantidade de Atributos

```java
function classeTemUmUnicoAtributo(){
  AssertEquals(1, DC.getClassAttributes("Produto").length);
  // or 
  AssertEquals(1, DC.howManyAttributesClassHas("Produto"));
}

/*
  DUVIDA:
	Se a classe herda atributos de uma outra classe, eu devo considerar esses atributos como pertencentes à subclasse, ou somente a superclasse? Por exemplo, quero verificar se a visibilidade de um atributo permite com que ele seja herdado. Quero verificar se a subclasse tem acesso ao atributo da superclasse.
*/

```

Verifica se duas classes compartilham os atributos de uma super classe comum

```java
function existemClassesParaOsQuatroTiposDeProduto(){
	AssertTrue(DC.isSubclassOf("Pagina", "Conteudo"));	
	AssertTrue(DC.isSubclassOf("Noticia", "Conteudo"));
  
  commonAttributes = ["titulo", "corpo"];  
  for(attr : commonAttributes){
      AssertTrue(DC.classHasAttribute("Pagina", attr));
      AssertTrue(DC.classHasAttribute("Noticia", attr));
  }
}
```

Verificar visibilidade de atributos

```java
function asClassesContemOsAtributosPrivados(){
  //attributes = DC.getClassAttributes("Pagina")
  attributes = DC.getClass("Pagina").getAttributes();
  for(attr : attributes){
    assertTrue(attr.isPrivate);
    // assertTrue(attr.isProtected);
    // assertTrue(attr.isPublic);
  }
}
```

Validar construtores

```java
// Dessa maneira também é facil analisar casos com mais de um construtor
function validaConstrutor(){
  listConstrutores = DC.getClassConstructors("Pagina")
  AssertEquals(1, listConstrutores.length); //Verifica a quantidade de construtores

  construtor = listConstrutores[0];
  params = construtor.getParams();
  AssertEquals(3, params.length); //Verifica sua quantidade de parametros

  // Verifica a ordem dos seus parametros
  AssertEquals("titulo", params[0].name);
  AssertEquals("corpo", params[1].name);
  AssertEquals("endereco", params[2].name);

  // Valida o tipo
  for(p : params){
    assertTrue(String, p.type);
  }
}
```

Verificar se métodos foram sobrepostos:

```java
function getPrecoEGetPrazoDevemSerSobrepostos(){
  assertTrue(DC.getClassMethod("FilmeInfantil", "getPreco").isOverrided);
  assertTrue(DC.getClassMethod("FilmeInfantil", "getPrazo").isOverrided);
  assertTrue(DC.getClassMethod("FilmeLancamento", "getPreco").isOverrided);
  assertTrue(DC.getClassMethod("FilmeLancamento", "getPrazo").isOverrided); 
}
```

Verificar se métodos são estáticos

```java
function metodoMediaDeveSerEstatico(){
  assertTrue(DC.getClassMethod("Aluno", "media").isStatic);
}
```

Valida tipos de atributos

```java
function veiculoDevePossuirOsAtributosIndicados(){
	assertEquals(String.class, DC.getClassAttribute("Veiculo","placa").getType());
	assertEquals(int.class, DC.getClassAttribute("Veiculo","renavam").getType());
  assertEquals(Pessoa.class, DC.getClassAttribute("Veiculo","condutor").getType());
}
```

Valida se classe implementa interface

```java
function mamiferoDeveImplementarInterfaceAnimal(){
	AsserTrue(DC.getClass("Mamifero").implements("Animal"));
  AsserTrue(DC.getClass("Ave").implements("Animal"));
  
  //AsserTrue(DC.getClass("ClassName").implements("Interface"));
  //AsserTrue(DC.getClass("ClassName").implements(interfaceList));
}
```

Valida se classe é abstrada

```java
function mamiferoEAveSaoClassesAbstratas(){
  AsserTrue(DC.getClass("Mamifero").isAbstract());
  AsserTrue(DC.getClass("Ave").isAbstract());
  // or           
  assertTrue(DC.isInterfaceImplemetedByClass("Animal", "Interface");
  assertTrue(DC.classImplements("Mamifero", "Animal"); 
}
```



