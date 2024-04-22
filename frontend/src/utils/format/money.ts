export const FORMAR_PRICE_V1 = (price: number): string => {
  const options = {
    style: 'currency',
    currency: 'BRL',
    maximumFractionDigits: 2,
    minimumFractionDigits: 2
  };
  return new Intl.NumberFormat('pt-BR', options).format(price);
};

export const FORMAR_REAL_V1 = (price: number): string => {
  const options = {
    maximumFractionDigits: 2,
    minimumFractionDigits: 2
  };
  return new Intl.NumberFormat('pt-BR', options).format(price);
};

export const formatValue = (value: number): string => {
  return value.toLocaleString('pt-BR', {
    style: 'currency',
    currency: 'BRL'
  });
};

export const formatBigDecimal = (valor: string): number => {
  if (!valor) 0;
  //2.000,00 -> 2.000,00
  return parseFloat(valor.replace('.', '').replace(',', '.'));
};

export const FORMATBIGDECIMAL = (valor: string): number => {
  if (!valor) 0;
  //2.000,00 -> 2.000,00
  return parseFloat(valor.replace('.', '').replace(',', '.'));
};

export const FORMATREAL = (valor: string) => {
  const v = ((+valor.replace(/\D/g, '') / 100).toFixed(2) + '').split('.');

  const m: RegExpMatchArray | null = v[0]
    .split('')
    .reverse()
    .join('')
    .match(/.{1,3}/g);

  if (m) {
    for (let i = 0; i < m.length; i++)
      m[i] = m[i].split('').reverse().join('') + '.';

    const r = m.reverse().join('');
    return r.substring(0, r.lastIndexOf('.')) + ',' + v[1];
  }
};

export const FORMAT_REAL = (value: string) => {
  value = value.replace('.', '').replace(',', '').replace(/\D/g, '');

  const options = { minimumFractionDigits: 2 };
  const result = new Intl.NumberFormat('pt-BR', options).format(
    parseFloat(value) / 100
  );

  console.log(result);

  return 'R$ ' + result;
};

// export const { format: formatPrice } = new Intl.NumberFormat('pt-br', {
//   style: 'currency',
//   currency: 'BRL',
// });
