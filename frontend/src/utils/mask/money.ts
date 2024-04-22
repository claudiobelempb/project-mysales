export const MASKREAL = (str: string) => {
  const value: string[] = (
    (parseInt(str.replace(/\D/g, '')) / 100).toFixed(2) + ''
  ).split('.');

  const match: any = value[0]
    .split('')
    .reverse()
    .join('')
    .match(/.{1,3}/g);

  for (let i = 0; i < match.length; i++)
    match[i] = match[i].split('').reverse().join('') + '.';

  const rerult = match.reverse().join('');

  return rerult.substring(0, rerult.lastIndexOf('.')) + ',' + value[1];
};

export const MASKPRICEV1 = (price: string): string => {
  if (!price) {
    return '';
  }
  return price.replace('.', '').replace(',', '.');
};

/*Função que padroniza valor monétario*/
export const MASKVALUE = (value: string) => {
  value = value.replace(/\D/g, ''); //Remove tudo o que não é dígito
  value = value.replace(/^([0-9]{3}\.?){3}-[0-9]{2}$/, '$1.$2');
  // value = value.replace(/(\d{3})(\d)/g, '$1,$2');
  value = value.replace(/(\d)(\d{2})$/, '$1.$2'); //Coloca ponto antes dos 2 últimos digitos
  return value;
};
