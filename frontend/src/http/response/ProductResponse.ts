export type ProductResponse = {
  id?: number;
  sku: string;
  name: string;
  price: number | string;
  description: string;
  createdAt?: string;
};
