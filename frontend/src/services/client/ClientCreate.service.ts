import { api } from '@/http/api';
import { ClientFormDTO } from '@/http/response/ClientDTO';
import { ProductDTO } from '@/http/response/ProductResponse';
import { AxiosResponse } from 'axios';

export const ClientCreateService = async (
  client: ClientFormDTO
): Promise<ProductDTO> => {
  const response: AxiosResponse<ProductDTO> = await api.post<ProductDTO>(
    '/v1/clients',
    client
  );
  return response.data;
};
