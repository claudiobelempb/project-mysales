import { api } from '@/http/api';

export const ProductDeleteService = async (id: number): Promise<void> => {
  await api.delete(`/v1/products/${id}`);
};
