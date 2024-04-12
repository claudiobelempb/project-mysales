import { api } from '@/http/api';
import { ProductResponse } from '@/http/response/ProductResponse';
import { AxiosResponse } from 'axios';

export const ProductFindByIdService = async (
  id: string
): Promise<ProductResponse> => {
  const response: AxiosResponse<ProductResponse> = await api.get(
    `/v1/products/${id}`
  );
  return response.data;
};
