/*Função que permite apenas numeros Romanos*/
export const MASKROMANOS = (value: string) => {
  value = value.toUpperCase();
  value = value.replace(/[^IVXLCDM]/g, '');

  while (
    value.replace(
      /^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$/,
      ''
    ) != ''
  )
    value = value.replace(/.$/, '');
  return value;
};

/*Função que padroniza o Site*/
export const MASKSITE = (value: string) => {
  value = value.replace(/^http:\/\/?/, '');
  let dominio = value;
  let caminho = '';
  if (value.indexOf('/') > -1) dominio = value.split('/')[0];
  caminho = value.replace(/[^\/]*/, '');
  dominio = dominio.replace(/[^\w\.\+-:@]/g, '');
  caminho = caminho.replace(/[^\w\d\+-@:\?&=%\(\)\.]/g, '');
  caminho = caminho.replace(/([\?&])=/, '$1');
  if (caminho != '') dominio = dominio.replace(/\.+$/, '');
  value = 'http://' + dominio + caminho;
  return value;
};

/*Função que padroniza Area*/
export const MASKAREA = (value: string) => {
  value = value.replace(/\D/g, '');
  value = value.replace(/(\d)(\d{2})$/, '$1.$2');
  return value;
};
