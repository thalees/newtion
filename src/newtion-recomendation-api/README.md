# Newtion recomendation API

Entre alguns dados disponíveis para treinar o algoritmo, foi possível levantar:

- Verificar se o usuário gosta de:
  - Notícias
  - Esportes
  - Artigos
  - Entretenimento
  - Política
  - Tecnologia

Para isso, levantamos 4 perfis para podermos treinar o algoritmo com base nas categorias acima. Estes são:

- reader 1 -> gosta de ler coisas em geral, menos coisas técnicas.
- reader 2 -> gosta de tecnolgia, e se manter informado
- reader 3 -> gosta de tecnologia e entretenimento
- reader 4 -> gosta de esportes

## Sumário:

A response retornará o ID de cada perfil pré definido. No caso, os ID's de cada perfil são:

- reader1 -> 0
- reader2 -> 1
- reader3 -> 2
- reader4 -> 3

Response:

```json
{
  "profile": "leitor em geral",
  "readerTypeId": 1
}
```

# Como usar?

- `docker build -t newtion-recomendation-api:latest .`
- `docker run -d -p 5000:5000 newtion-recomendation-api`
