export const formatDate = (data: string): string => {
  return new Intl.DateTimeFormat('pt-BR', {
    year: 'numeric',
    month: 'long',
    day: '2-digit'
  }).format(new Date(data));
};

export const dateFormatted = (str: string): string => {
  let data = new Date(str);
  return data.toLocaleDateString('pt-br', {
    day: '2-digit',
    month: 'numeric',
    year: 'numeric'
  });
};
